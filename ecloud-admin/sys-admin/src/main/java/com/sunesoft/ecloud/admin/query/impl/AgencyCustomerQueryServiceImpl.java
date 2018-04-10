package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyCustomer;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.query.AgencyCustomerQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
public class AgencyCustomerQueryServiceImpl extends GenericQuery implements AgencyCustomerQueryService {

//    public static final UUID agId = UUID.fromString("200e6946-70e3-4087-839a-0491c631caf1");

    @Value("${ecloud.agId}")
    private UUID agId;

    @Override
    public PagedResult<AgencyCustomerDto> findAgencyCustomerPaged(AgencyCustomerCriteria criteria) {
        SqlBuilder<AgencyCustomerDto> dtoBuilder = HSqlBuilder.hFrom(AgencyCustomer.class, "c")
                .leftJoin(User.class,"u")
                .on("c.consultantId = u.id")
                //.where("c.agId",agId)
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .select(AgencyCustomerDto.class)
                .setFieldValue("consultantId","u.id")
                .setFieldValue("consultantName","u.realName");
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public TResult<AgencyCustomerDto> findAgencyCustomerBasicById(UUID id) {
        SqlBuilder<AgencyCustomerDto> dtoBuilder = HSqlBuilder.hFrom(AgencyCustomer.class, "c")
                .leftJoin(User.class,"u")
                .on("c.consultantId = u.id")
                .where("id",id)
                .select(AgencyCustomerDto.class)
                .setFieldValue("consultantId","u.id")
                .setFieldValue("consultantName","u.realName");
        return new TResult<>(this.queryForObject(dtoBuilder));
    }


}
