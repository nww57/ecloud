package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.query.AgencyQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.IEntity;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
@Service
@SuppressWarnings("All")
public class AgencyQueryServiceImpl extends GenericQuery implements AgencyQueryService {

    @Override
    public Page<AgencyDto> findAgencyPaged(AgencyCriteria criteria) {

        SqlBuilder builder = HSqlBuilder.hFrom(Agency.class, "agency")
                .pagging(criteria.getPageIndex(), criteria.getPageSize())
                .select(AgencyDto.class);
        return this.queryPaged(builder);
    }

    @Override
    public TResult<AgencyBasicDto> findAgencyBasicInfoById(UUID id) {
        SqlBuilder<AgencyBasicDto> builder = HSqlBuilder.hFrom(Agency.class,"agency").where("id",id).select(AgencyBasicDto.class);
        AgencyBasicDto dto = queryForObject(builder);
        return new TResult<>(dto);
    }

    @Override
    public TResult<AgencyDto> findAgencyDetailInfoById(UUID id) {
        SqlBuilder<AgencyDto> builder = HSqlBuilder.hFrom(Agency.class,"agency").where("id",id).select(AgencyDto.class);
        AgencyDto dto = queryForObject(builder);

        //获取企业拥有的菜单
        SqlBuilder<BasicDto> menuList = HSqlBuilder.hFrom(AgencyAuthorizedMenu.class,"agMenu")
                .where("agMenu.agId",id)
                .select(BasicDto.class)
                .selectField("agMenu.menuId","id");
        List<UUID> menuIds =  queryList(menuList).stream().map(BasicDto::getId).collect(Collectors.toList());
        dto.setMenuIds(menuIds);

        return new TResult<>(dto);
    }


}
