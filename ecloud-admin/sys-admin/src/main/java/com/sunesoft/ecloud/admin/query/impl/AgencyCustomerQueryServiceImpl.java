package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.*;
import com.sunesoft.ecloud.admin.query.AgencyCustomerQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerContactsDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
public class AgencyCustomerQueryServiceImpl extends GenericQuery implements AgencyCustomerQueryService {


    @Override
    public PagedResult<AgencyCustomerDto> findAgencyCustomerPaged(AgencyCustomerCriteria criteria) {
        UUID agId = criteria.getAgId();
        if (null == agId) {
            throw new IllegalArgumentException("企业id不能为null");
        }
        String keywords = criteria.getKeywords();
        SqlBuilder<AgencyCustomerDto> dtoBuilder = HSqlBuilder.hFrom(AgencyCustomer.class, "c")
                .leftJoin(User.class, "u")
                .on("c.consultantId = u.id")
                .where("c.agId", agId);
        if (StringUtils.isNotEmpty(keywords)) {
            dtoBuilder.and(" (c.name like '%" + keywords + "%' or c.leader like '%" + keywords + "%' or c.leaderMobile like '%" + keywords + "%' )");
        }
        dtoBuilder.pagging(criteria.getPageIndex(), criteria.getPageSize())
                .select(AgencyCustomerDto.class)
                .setFieldValue("consultantId", "u.id")
                .setFieldValue("consultantName", "u.realName");
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public TResult<AgencyCustomerDto> findAgencyCustomerBasicById(UUID id) {
        SqlBuilder<AgencyCustomerDto> dtoBuilder = HSqlBuilder.hFrom(AgencyCustomer.class, "c")
                .leftJoin(User.class, "u")
                .on("c.consultantId = u.id")
                .where("id", id)
                .select(AgencyCustomerDto.class)
                .setFieldValue("consultantId", "u.id")
                .setFieldValue("consultantName", "u.realName");
        return new TResult<>(this.queryForObject(dtoBuilder));
    }

    @Override
    public PagedResult<CustomerApplicantDto> findCustomerApplicantPaged(UUID customerId, Pageable pageable) {
        SqlBuilder<CustomerApplicantDto> dtoBuilder = HSqlBuilder.hFrom(CustomerApplicant.class, "a")
                .where("a.customerId", customerId)
                .pagging(pageable.getPageNumber(),pageable.getPageSize())
                .select(CustomerApplicantDto.class);
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public PagedResult<CustomerInventorDto> findCustomerInventorPaged(UUID customerId, Pageable pageable) {
        SqlBuilder<CustomerInventorDto> dtoBuilder = HSqlBuilder.hFrom(CustomerInventor.class, "i")
                .where("i.customerId", customerId)
                .pagging(pageable.getPageNumber(),pageable.getPageSize())
                .select(CustomerInventorDto.class);
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public PagedResult<CustomerContactsDto> findCustomerContactsPaged(UUID customerId, Pageable pageable) {
        SqlBuilder<CustomerContactsDto> dtoBuilder = HSqlBuilder.hFrom(CustomerContact.class, "c")
                .where("c.customerId", customerId)
                .pagging(pageable.getPageNumber(),pageable.getPageSize())
                .select(CustomerContactsDto.class);
        return this.queryPaged(dtoBuilder);
    }


}
