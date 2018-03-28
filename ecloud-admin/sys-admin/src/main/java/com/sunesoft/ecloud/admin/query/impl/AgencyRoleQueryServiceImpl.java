package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.query.AgencyRoleQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleViewDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
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
        //todo 查询菜单
        return new TResult<>(dto);
    }

    @Override
    public TResult<AgencyRoleViewDto> getAgencyRoleFullById(UUID id) {
        AgencyRoleViewDto viewDto = new AgencyRoleViewDto();
        SqlBuilder<AgencyRoleDto> dtoBuilder = HSqlBuilder.hFrom(AgencyRole.class, "role")
                .where("id",id)
                .select(AgencyRoleViewDto.class);
        //todo 查询菜单
        return new TResult<>(viewDto);
    }

    @Override
    public ListResult<BasicDto> getAgencyRoleIdName() {
        SqlBuilder<BasicDto> dtoBuilder = HSqlBuilder.hFrom(AgencyRole.class, "role")
                .select(AgencyRoleViewDto.class);
        return null;
    }
}
