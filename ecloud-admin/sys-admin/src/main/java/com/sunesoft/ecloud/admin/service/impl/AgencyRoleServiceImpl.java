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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
                    }
                    List<MenuFunction> functions  = functionList.stream().filter(f->map.getValue().contains(f.getId())).collect(Collectors.toList());
                    for (MenuFunction function : functions) {
                        menuFunc = new AgencyMenuAuthorizedFunction();
                        menuFunc.setMenuFunction(function);
                        menuFuncList.add(menuFunc);
                    }
                    roleMenu.setRoleMenuFunctionEntities(menuFuncList);
                    roleMenuList.add(roleMenu);
                }
                roleMenuRepository.save(roleMenuList);
            }
        }

        return new TResult<>(agencyRoleDto);
    }

    @Override
    @Transactional
    public TResult delete(UUID id) {
        roleRepository.delete(id);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult deleteBatch(UUID... ids) {
        roleRepository.deleteBatch(ids);
        return (TResult) ResultFactory.success();
    }
}