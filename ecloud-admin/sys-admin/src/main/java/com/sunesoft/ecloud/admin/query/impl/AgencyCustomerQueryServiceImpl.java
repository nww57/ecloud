package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.*;
import com.sunesoft.ecloud.admin.query.AgencyCustomerQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerApplicantCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerContactCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerInventorCriteria;
import com.sunesoft.ecloud.adminclient.dtos.*;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.OrderType;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.common.utils.StringUtil;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if(StringUtils.isNotEmpty(criteria.getCustomerName())){
            dtoBuilder.and(" c.name like '%"+criteria.getCustomerName()+"%' ");
        }
        if(StringUtils.isNotEmpty(criteria.getLeader())){
            dtoBuilder.and(" c.leader like '%"+criteria.getLeader()+"%' ");
        }
        if(StringUtils.isNotEmpty(criteria.getLeaderMobile())){
            dtoBuilder.and(" c.leaderMobile like '%"+criteria.getLeaderMobile()+"%' ");
        }
        if(StringUtils.isNotEmpty(criteria.getLeaderEmail())){
            dtoBuilder.and(" c.leaderEmail like '%"+criteria.getLeaderEmail()+"%' ");
        }
        if(StringUtils.isNotEmpty(criteria.getConsultantName())){
            dtoBuilder.and(" u.realName like '%"+criteria.getCustomerName()+"%' ");
        }
        if(StringUtils.isNotEmpty(criteria.getSignDateStart())){
            dtoBuilder.and(" c.signDate >= '"+criteria.getSignDateStart()+"' ");
        }
        if(StringUtils.isNotEmpty(criteria.getSignDateEnd())){
            dtoBuilder.and(" c.signDate <= '"+criteria.getSignDateEnd()+"' ");
        }
        dtoBuilder.pagging(criteria.getPageIndex(), criteria.getPageSize())
                .orderBy("c.create_datetime",OrderType.DESC)
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
    public PagedResult<CustomerApplicantDto> findCustomerApplicantPaged(UUID customerId, CustomerApplicantCriteria criteria) {
        SqlBuilder<CustomerApplicantDto> dtoBuilder = HSqlBuilder.hFrom(CustomerApplicant.class, "a")
                .where("a.customerId", customerId)
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .orderBy("create_datetime", OrderType.DESC)
                .select(CustomerApplicantDto.class);
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public ListResult<CustomerApplicantDto> findCustomerApplicantList(UUID customerId) {
        if(null == customerId){
            throw new IllegalArgumentException("参数customerId不能为null");
        }
        SqlBuilder<CustomerApplicantDto> dtoBuilder = HSqlBuilder.hFrom(CustomerApplicant.class, "a")
                .where("a.customerId", customerId)
                .select(CustomerApplicantDto.class);
        return new ListResult<>(queryList(dtoBuilder));
    }

    @Override
    public TResult<CustomerApplicantDto> findCustomerApplicantById(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("参数id不能为null");
        }
        SqlBuilder<CustomerApplicantDto> dtoBuilder = HSqlBuilder.hFrom(CustomerApplicant.class, "a")
                .where("id", id)
                .select(CustomerApplicantDto.class);
        return new TResult<>(queryForObject(dtoBuilder));
    }

    @Override
    public ListResult<CustomerApplicantDto> findCustomerApplicantByIdList(List<UUID> applicantIdList) {
        if(null == applicantIdList || applicantIdList.size() ==0){
            throw new IllegalArgumentException("参数applicantIdList没有值");
        }
        SqlBuilder<CustomerApplicantDto> dtoBuilder = HSqlBuilder.hFrom(CustomerApplicant.class, "a")
                .where("id", applicantIdList)
                .select(CustomerApplicantDto.class);
        return new ListResult<>(queryList(dtoBuilder));
    }

    @Override
    public PagedResult<CustomerInventorDto> findCustomerInventorPaged(UUID customerId, CustomerInventorCriteria criteria) {
        SqlBuilder<CustomerInventorDto> dtoBuilder = HSqlBuilder.hFrom(CustomerInventor.class, "i")
                .where("i.customerId", customerId)
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .select(CustomerInventorDto.class);
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public ListResult<CustomerInventorDto> findCustomerInventorList(UUID customerId) {
        if(null == customerId){
            throw new IllegalArgumentException("参数customerId不能为null");
        }
        SqlBuilder<CustomerInventorDto> dtoBuilder = HSqlBuilder.hFrom(CustomerInventor.class, "i")
                .where("i.customerId", customerId)
                .select(CustomerInventorDto.class);
        return new ListResult<>(queryList(dtoBuilder));
    }

    @Override
    public TResult<CustomerInventorDto> findCustomerInventorById(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("参数id不能为null");
        }
        SqlBuilder<CustomerInventorDto> dtoBuilder = HSqlBuilder.hFrom(CustomerInventor.class, "a")
                .where("id", id)
                .select(CustomerInventorDto.class);
        return new TResult<>(queryForObject(dtoBuilder));
    }

    @Override
    public ListResult<CustomerInventorDto> findCustomerInventorByIdList(List<UUID> idList) {
        if(null == idList || idList.size()==0){
            throw new IllegalArgumentException("参数idList没有没有值");
        }
        SqlBuilder<CustomerInventorDto> dtoBuilder = HSqlBuilder.hFrom(CustomerInventor.class, "a")
                .where("id", idList)
                .select(CustomerInventorDto.class);
        return new ListResult<>(queryList(dtoBuilder));
    }

    @Override
    public PagedResult<CustomerContactDto> findCustomerContactsPaged(UUID customerId, CustomerContactCriteria criteria) {
        SqlBuilder<CustomerContactDto> dtoBuilder = HSqlBuilder.hFrom(CustomerContact.class, "c")
                .where("c.customerId", customerId)
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .select(CustomerContactDto.class);
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public ListResult<BasicDto> findCustomerContactsList(UUID customerId) {
        if(null == customerId){
            throw new IllegalArgumentException("参数customerId不能为null");
        }
        SqlBuilder<BasicDto> dtoBuilder = HSqlBuilder.hFrom(CustomerContact.class, "c")
                .where("c.customerId", customerId)
                .select(BasicDto.class);
        return new ListResult<>(queryList(dtoBuilder));
    }

    @Override
    public TResult<CustomerContactDto> findCustomerContactById(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("参数id不能为null");
        }
        SqlBuilder<CustomerContactDto> dtoBuilder = HSqlBuilder.hFrom(CustomerContact.class, "c")
                .where("id", id)
                .select(CustomerContactDto.class);
        return new TResult<>(queryForObject(dtoBuilder));
    }

    @Override
    public ListResult<AgencyCustomerBasicDto> getAgencyCustomerBasicInfo(UUID agId) {
        if(null == agId){
            throw new IllegalArgumentException("企业id不能为null");
        }
        SqlBuilder<AgencyCustomerBasicDto> dtoBuilder = HSqlBuilder.hFrom(AgencyCustomer.class, "ac")
                .leftJoin(User.class,"u")
                .on("u.id = ac.consultantId")
                .where("agId", agId)
                .orderBy("ac.create_datetime",OrderType.DESC)
                .select(AgencyCustomerBasicDto.class)
                .setFieldValue("leaderName","ac.leader")
                .setFieldValue("consultantName","u.realName");
        return new ListResult<>(queryList(dtoBuilder));
    }


}
