package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRoleAuthorizedMenu;
import com.sunesoft.ecloud.admin.repository.AgencyAuthorizedMenuRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRoleRepository;
import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleMenuDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    AgencyAuthorizedMenuRepository agMenuRepository;

    @Override
    public TResult addOrUpdateRole(AgencyRoleDto agencyRoleDto) {
        UUID agId = UUID.fromString("c5accfc4-7e7f-488d-8c04-a6ce4894401d");

        UUID id  = agencyRoleDto.getId();
        AgencyRole role;
        if(null == id){
            role = new AgencyRole();
        }else{
            role = roleRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(agencyRoleDto,role);
        Agency agency = agencyRepository.findOne(agId);
        role.setAgency(agency);
        //配置权限
        List<AgencyRoleMenuDto> menuDtoList = agencyRoleDto.getAuthList();
        List<UUID> menuIds = new ArrayList<>();
        menuDtoList.forEach(menuDto->{
            menuIds.add(menuDto.getId());
        });

        List<AgencyRoleAuthorizedMenu> roleMenuList = new ArrayList<>();
        List<AgencyAuthorizedMenu> agMenus =  agMenuRepository.findByMenuIn(menuIds);
        agMenus.forEach(agMenu->{
            AgencyRoleAuthorizedMenu roleMenu = new AgencyRoleAuthorizedMenu();
            roleMenu.setAgencyMenu(agMenu);
            roleMenuList.add(roleMenu);
        });
        role.setRoleAuthMenu(roleMenuList);
        roleRepository.saveAndFlush(role);
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
