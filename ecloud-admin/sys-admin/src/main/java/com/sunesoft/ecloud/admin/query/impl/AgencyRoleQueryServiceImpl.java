package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.agency.AgencyMenuAuthorizedFunction;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRoleAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.admin.query.AgencyRoleQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleViewDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuFuncIdDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
@SuppressWarnings("ALL")
public class AgencyRoleQueryServiceImpl extends GenericQuery implements AgencyRoleQueryService {


    private static final UUID agId = UUID.fromString("200e6946-70e3-4087-839a-0491c631caf1");

    @Override
    public Page<AgencyRoleDto> findAgencyRolePaged(AgencyRoleCriteria criteria) {
        SqlBuilder<AgencyRoleDto> dtoBuilder = HSqlBuilder.hFrom(AgencyRole.class, "role")
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .select(AgencyRoleDto.class);
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public TResult<AgencyRoleDto> getAgencyRoleBasicById(UUID id) {
        AgencyRoleDto dto = new AgencyRoleDto();
        SqlBuilder<AgencyRoleDto> dtoBuilder = HSqlBuilder.hFrom(AgencyRole.class, "role")
                .where("id",id)
                .select(AgencyRoleDto.class);
        dto = queryForObject(dtoBuilder);
        //查询菜单id
        SqlBuilder<BasicDto> roleMenuList = HSqlBuilder.hFrom(AgencyRoleAuthorizedMenu.class, "roleMenu")
                .leftJoin(AgencyAuthorizedMenu.class,"agMenu")
                .on("agMenu.id = roleMenu.menuId")
                .where("roleMenu.roleId",id)
                .select(BasicDto.class)
                .selectField("agMenu.menuId","id");
        List<UUID> roleMenuListId = queryList(roleMenuList).stream().map(BasicDto::getId).collect(Collectors.toList());
        //获取功能
        SqlBuilder<MenuFuncIdDto> funcList = HSqlBuilder.hFrom(AgencyRoleAuthorizedMenu.class, "roleMenu")
                .leftJoin(AgencyMenuAuthorizedFunction.class,"roleMenuFunc")
                .on("roleMenu.id = roleMenuFunc.roleMenuId")
                .leftJoin(MenuFunction.class,"func")
                .on("func.id = roleMenuFunc.funcId")
                .where("roleMenu.roleId",id)
                .select(MenuFuncIdDto.class)
                .setFieldValue("menuId","func.menuId")
                .setFieldValue("funcId","func.id");
        List<MenuFuncIdDto> menuFuncDtoList = queryList(funcList);
        Map<UUID,List<UUID>> map = new HashMap<>();
        roleMenuListId.forEach(menuId->{
            if(null == map.get(menuId)){
                map.put(menuId,new ArrayList<>());
            }
            menuFuncDtoList.forEach(menuFunc->{
                if(Objects.equals(menuFunc.getMenuId(),menuId)){
                    map.get(menuId).add(menuFunc.getFuncId());
                }
            });
        });
        dto.setAuthList(map);
        return new TResult<>(dto);
    }


    @Override
    public ListResult<BasicDto> getAgencyRoleIdName() {
        SqlBuilder<BasicDto> dtoBuilder = HSqlBuilder.hFrom(AgencyRole.class, "role")
                .select(BasicDto.class);
        return new ListResult<>(queryList(dtoBuilder));
    }


}
