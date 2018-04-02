package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.repository.AgencyAuthorizedMenuRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRoleAuthorizedMenuRepository;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.UserType;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.ConvertUtil;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class AgencyServiceImpl implements AgencyService{

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

    @Override
    public TResult addOrUpdateAgency(AgencyDto agencyDto) {
        if(null == agencyDto){
            throw new IllegalArgumentException("无效的参数");
        }
        //todo :验证参数
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
                    roleMenuList.forEach(r->
                            roleMenuRepository.delete(UUID.fromString(r))
                    );
                }
                agMenuRepository.deleteByIdBatch(deleteId);
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
            user.setUserName(agencyDto.getCellphone());
            user.setPassword("888888");
            user.setCallphone(agencyDto.getCellphone());
            user.setEmail(agencyDto.getEmail());
            userservice.addOrUpdateUser(user);
        }

        return new TResult<>(agencyDto);
    }

    @Override
    public TResult updateAgencyBasicInfo(AgencyBasicDto AgencyBasicDto) {
        UUID id = AgencyBasicDto.getId();
        Agency agency = agencyRepository.findOne(id);
        BeanUtil.copyProperties(AgencyBasicDto,agency,new String[]{"serverStatus"});
        agencyRepository.saveAndFlush(agency);
        return new TResult<>(AgencyBasicDto);
    }


    @Override
    public TResult delete(UUID id) {
        agencyRepository.delete(id);
        return new TResult<>(true);
    }

    @Override
    @Transactional
    public TResult deleteBatch(UUID... ids) {
        for (UUID id : ids) {
            agencyRepository.delete(id);
        }
        return new TResult<>(true);
    }
}
