package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.agency.AgencyMenuAuthorizedFunction;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRoleAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.admin.repository.*;
import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
@Transactional
public class AgencyRoleServiceImpl implements AgencyRoleService {

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    AgencyRoleRepository roleRepository;
    @Autowired
    AgencyRoleAuthorizedMenuRepository roleMenuRepository;
    @Autowired
    AgencyAuthorizedMenuRepository agencyMenuRepository;
    @Autowired
    MenuFunctionRepository menuFuncRepository;
    @Value("${ecloud.agId}")
    private UUID agId;
    @Override
    public TResult addOrUpdateRole(AgencyRoleDto agencyRoleDto) {

        //参数检查
        TResult checkResult = checkParam(agencyRoleDto);
        if(!checkResult.getIs_success()){
            return checkResult;
        }
        UUID id  = agencyRoleDto.getId();
        AgencyRole role;
        if(null == id){
            role = new AgencyRole();
        }else{
            role = roleRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(agencyRoleDto,role);
        role.setAgencyId(agId);
        roleRepository.saveAndFlush(role);
        //设置权限
        Map<UUID,List<UUID>> authList = agencyRoleDto.getAuthList();
        if(null!=authList && authList.size()>0){
            List<UUID> menuList = new ArrayList<>();
            List<UUID> funcList = new ArrayList<>();
            authList.forEach((key,value)->{
                menuList.add(key);
                funcList.addAll(value);
            });
            //先删除，在添加
            //根据menuId查找已经存在的记录
            List<String> menuListString = menuList.stream().map(UUID::toString).collect(Collectors.toList());
            List<String> uuidList = roleMenuRepository.getIdByMenuId(menuListString);
            if(null!=uuidList&& uuidList.size()>0){
                uuidList.forEach(uuid -> {
                    if(null != uuid){
                        roleMenuRepository.delete(UUID.fromString(uuid));
                    }
                });
            }
            //根据  菜单id 查询
            List<AgencyAuthorizedMenu> agencyMenuList = agencyMenuRepository.getAgencyAuthMenu(menuListString);
            if(null !=agencyMenuList && agencyMenuList.size()>0){
                List<MenuFunction> functionList = menuFuncRepository.findAll(funcList);
                List<AgencyRoleAuthorizedMenu> roleMenuList = new ArrayList<>();
                AgencyRoleAuthorizedMenu roleMenu;
                List<AgencyMenuAuthorizedFunction> menuFuncList;
                AgencyMenuAuthorizedFunction menuFunc;
                for(Map.Entry<UUID,List<UUID>> map:authList.entrySet()){
                    roleMenu = new AgencyRoleAuthorizedMenu();
                    menuFuncList = new ArrayList<>();
                    roleMenu.setRole(role);
                    Optional<AgencyAuthorizedMenu> optional = agencyMenuList.stream().filter(f-> Objects.equals(f.getMenu().getId(),map.getKey())).findAny();
                    if(optional.isPresent()){
                        roleMenu.setAgencyMenu(optional.get());
                        List<MenuFunction> functions  = functionList.stream().filter(f->map.getValue().contains(f.getId())).collect(Collectors.toList());
                        for (MenuFunction function : functions) {
                            menuFunc = new AgencyMenuAuthorizedFunction();
                            menuFunc.setMenuFunction(function);
                            menuFuncList.add(menuFunc);
                        }
                        roleMenu.setRoleMenuFunctionEntities(menuFuncList);
                        roleMenuList.add(roleMenu);
                    }
                }
                roleMenuRepository.save(roleMenuList);
            }
        }

        return new TResult<>(agencyRoleDto);
    }



    @Override
    public TResult delete(UUID id) {
        //删除角色跟用户的关联关系
        roleRepository.deleteRoleUserRel(id.toString());
        //在删除角色信息
        roleRepository.delete(id);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult deleteBatch(UUID... ids) {
        for (UUID id : ids) {
            delete(id);
        }
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult<Boolean> checkRoleNameExist(UUID id, String name) {
        Specification querySpecification = (Specification<AgencyRole>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("agencyId"), agId));
            if(null != id){
                predicates.add(criteriaBuilder.notEqual(root.get("id"), id));
            }
            if(null != name){
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<AgencyRole> roleList =  roleRepository.findAll(querySpecification);
        if(null != roleList && roleList.size()>0){
            return new TResult<>(true);
        }
        return new TResult<>(false);
    }

    private TResult checkParam(AgencyRoleDto agencyRoleDto) {
        if(StringUtils.isEmpty(agencyRoleDto.getName())){
            return new TResult("角色名不能为空");
        }
        if(StringUtils.isEmpty(agencyRoleDto.getDescription())){
            return new TResult("角色描述不能为空");
        }
        TResult<Boolean> roleNameChecked = checkRoleNameExist(agencyRoleDto.getId(),agencyRoleDto.getName());
        if(roleNameChecked.getResult()){
            return new TResult("角色名已经存在");
        }
        return (TResult) ResultFactory.success();
    }
}