package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.repository.*;
import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.UserType;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.adminclient.dtos.TreeDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.ConvertUtil;
import com.sunesoft.ecloud.common.utils.StringUtil;
import com.sunesoft.ecloud.hibernate.repository.HibernateQuery;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 企业接口实现
 */
@Service
@Transactional
public class AgencyServiceImpl extends HibernateQuery implements AgencyService{

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    AgencyAuthorizedMenuRepository agMenuRepository;
    @Autowired
    MenuRepository  menuRepository;
    @Autowired
    AgencyAuthorizedMenuRepository authMenuRepository;
    @Autowired
    AgencyRoleAuthorizedMenuRepository roleMenuRepository;
    @Autowired
    UserService userservice;
    @Autowired
    AgencyOrganizationRepository orgRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AgencyRoleRepository roleRepository;

    @Override
    public TResult addOrUpdateAgency(AgencyDto agencyDto) {
        if(null == agencyDto){
            throw new IllegalArgumentException("无效的参数");
        }
        //验证参数
        TResult checkResult = checkParam(agencyDto);
        if(!checkResult.getIs_success()){
            return checkResult;
        }
        UUID id = agencyDto.getId();
        Agency agency ;
        List<AgencyAuthorizedMenu> agencyMenu;
        if(null == id){//新增
            agency = new Agency();
        }else{//修改
            agency = agencyRepository.findOne(id);
        }
        BeanUtil.copyProperties(agencyDto,agency,new String[]{"agencyType","serverStatus"});
        try{
            agency.setServerEndDate(DateUtils.parseDate(agencyDto.getServerEndDate(),new String[]{"yyyy-MM-dd HH:mm:ss"}));
            agency.setRegisterDate(DateUtils.parseDate(agencyDto.getRegisterDate(),new String[]{"yyyy-MM-dd"}));
        }catch (Exception e){
            e.printStackTrace();
        }

        // 配置菜单
        agency = agencyRepository.saveAndFlush(agency);
        List<UUID> menuIds = agencyDto.getMenuIds();
        if(null!=menuIds && menuIds.size()>0){
            UUID agId = agency.getId();
            //找出原有的菜单，跟新的匹配，去掉旧的，添加新的
            List<String> preAuthMenuList = agMenuRepository.getMenuId(agId.toString());

            List<UUID> addMenuIds = new ArrayList<>();
            List<String> deleteMenuIds = new ArrayList<>();
            preAuthMenuList.forEach(pre->{
                if(!menuIds.contains(UUID.fromString(pre))){
                    deleteMenuIds.add(pre);
                }
            });
            menuIds.forEach(m->{
                if(!preAuthMenuList.contains(m.toString())){
                    addMenuIds.add(m);
                }
            });
            //删除的
            if(deleteMenuIds.size()>0){
                List<String> deleteId = agMenuRepository.getDeleteId(deleteMenuIds);
                //查看要删除的关系记录是否被角色权限关联，如果没有，则直接删除，如果有，则先删除角色权限，再删除
                List<String> roleMenuList = roleMenuRepository.getIdByAgencyMenu(deleteId);
                if(null!=roleMenuList && roleMenuList.size()>0){
                    for (String s : roleMenuList) {
                        roleMenuRepository.delete(UUID.fromString(s));
                    }
                }
                for (String s : deleteId) {
                    agMenuRepository.delete(UUID.fromString(s));
                }
            }
            if(addMenuIds.size()>0){
                //新增的
                List<Menu> menus = menuRepository.findAll(addMenuIds);
                List<AgencyAuthorizedMenu> authMenuList = new ArrayList<>();
                AgencyAuthorizedMenu authMenu;
                for (Menu menu : menus) {
                    authMenu = new AgencyAuthorizedMenu();
                    authMenu.setAgencyId(agId);
                    authMenu.setMenu(menu);
                    authMenuList.add(authMenu);
                }
                authMenuRepository.save(authMenuList);
            }
        }

        //创建完企业后，创建一个管理用户
        if(null == id){
            UserDto user  = new UserDto();
            user.setUserType(UserType.AGENCY_ADMIN);
            user.setAgId(agency.getId());
            user.setUserName(agencyDto.getUserName());
            user.setPassword(agencyDto.getPassword());
            user.setCallphone(agencyDto.getCellphone());
            user.setEmail(agencyDto.getEmail());
            userservice.addOrUpdateUser(user);
        }

        return new TResult<>(agencyDto);
    }


    @Override
    public TResult updateAgencyBasicInfo(AgencyBasicDto agencyBasicDto) {
        UUID id = agencyBasicDto.getId();
        Agency agency = agencyRepository.findOne(id);
        BeanUtil.copyProperties(agencyBasicDto,agency,new String[]{"serverStatus"});
        agencyRepository.saveAndFlush(agency);
        return new TResult<>(agencyBasicDto);
    }


    @Override
    public TResult delete(UUID id) {
        //逻辑删除
        agencyRepository.deleteLogical(id);
        return (TResult) ResultFactory.success();
    }

    @Override
    @Transactional
    public TResult deleteBatch(UUID... ids) {
        //逻辑删除
        agencyRepository.deleteLogical(ids);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult<Boolean> checkAgencyCodeExist(UUID id,String code) {
        if(StringUtils.isEmpty(code)){
            return new TResult<>("参数错误");
        }
        Specification querySpecification = (Specification<Agency>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(null != id){
                predicates.add(criteriaBuilder.notEqual(root.get("id"), id));
            }
            predicates.add(criteriaBuilder.equal(root.get("code"), code));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<Agency> agencyList =  agencyRepository.findAll(querySpecification);
        if(null != agencyList && agencyList.size()>0){
            return new TResult<>(true);
        }
        return new TResult<>(false);

    }


    private TResult checkParam(AgencyDto agencyDto) {
        if(StringUtils.isEmpty(agencyDto.getName())){
            return new TResult("机构名称不能为空");
        }
        if(StringUtils.isEmpty(agencyDto.getCode())){
            return new TResult("机构编码不能为空");
        }
        TResult<Boolean> codeExist = checkAgencyCodeExist(agencyDto.getId(),agencyDto.getCode());
        if(codeExist.getIs_success()){
            if(codeExist.getResult()){
                return new TResult("机构编码已存在");
            }
        }
        if(StringUtils.isEmpty(agencyDto.getCountry())){
            return new TResult("所属国家不能为空");
        }
        if(StringUtils.isEmpty(agencyDto.getLeader())){
            return new TResult("负责人不能为空");
        }
        if(StringUtils.isEmpty(agencyDto.getCellphone())){
            return new TResult("电话不能为空");
        }
        if(StringUtils.isEmpty(agencyDto.getLeader())){
            return new TResult("所属国家不能为空");
        }
        if(StringUtils.isEmpty(agencyDto.getUserName())){
            return new TResult("账户用户名不能为空");
        }
        if(StringUtils.isEmpty(agencyDto.getPassword())){
            return new TResult("账户密码不能为空");
        }
        TResult<Boolean> userNameExist =  userservice.checkUserNameExist(null,agencyDto.getUserName());
        if(userNameExist.getIs_success()){
            if(userNameExist.getResult()){
                return new TResult("账户用户名已存在");
            }
        }
        return (TResult) ResultFactory.success();
    }
}
