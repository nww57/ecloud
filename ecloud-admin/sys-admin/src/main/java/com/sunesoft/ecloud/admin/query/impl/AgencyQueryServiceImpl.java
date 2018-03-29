package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.query.AgencyQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        SqlBuilder<AgencyDto> builder = HSqlBuilder.hFrom(Agency.class,"agency").where("id",id).select(AgencyBasicDto.class);
        AgencyDto dto = queryForObject(builder);
        return new TResult<>(dto);
    }

    @Override
    public TResult<AgencyDto> findAgencyDetailInfoById(UUID id) {
        return null;
    }


}