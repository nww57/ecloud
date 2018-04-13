package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoListDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageListDto;
import com.sunesoft.ecloud.caze.domain.CaseInfo;
import com.sunesoft.ecloud.caze.query.CaseQueryService;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
@Service
public class CaseQueryServiceImpl extends GenericQuery implements CaseQueryService {

    @Override
    public PagedResult<CaseInfoListDto> queryCaseInfoByPaged(CaseInfoQueryCriteria criteria) {
        if(null == criteria.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        String sql = "SELECT " +
                " ci.id,  " +
                " ci.caseNo,  " +
                " ci.caseName,  " +
                " ci.caseType,  " +
                " ci.creatorName,  " +
                " ci.feeReduceRate,  " +
                " ci.create_datetime,  " +
                " ci.comments,  " +
                " ac. NAME customerName,  " +
                " ac.leader,  " +
                " ac.leaderMobile,  " +
                " u.realName,  " +
                " p.id patentId,  " +
                " p.patentNo,  " +
                " p.patentName,  " +
                " p.patentType  " +
                " FROM " +
                " case_info ci  " +
                " LEFT JOIN sys_ag_customer ac ON ci.customerId = ac.id  " +
                " LEFT JOIN sys_user u ON u.id = ac.consultantId  " +
                " LEFT JOIN patent_info p ON p.caseId = ci.id  where 1=1 and ci.agId = '" +criteria.getAgId() +"' ";
        //参数设置
        PagedResult<CaseInfoListDto> infoList = queryPaged(criteria.getPageIndex(),criteria.getPageSize(),sql,new HashMap<>(),CaseInfoListDto.class);
        return null;
    }

    @Override
    public TResult<CaseInfoListDto> queryCaseBasicInfoById(UUID id) {
        return null;
    }

    @Override
    public PagedResult<CaseCustomerRequestDto> queryCaseCustomerRequestByPaged(UUID id, TCretiria criteria) {
        return null;
    }

    @Override
    public PagedResult<CaseMessageListDto> queryCaseMessageByPaged(UUID id, TCretiria criteria) {
        return null;
    }
}
