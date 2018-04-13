package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoListDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageListDto;
import com.sunesoft.ecloud.caze.query.CaseQueryService;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
@Service
public class CaseQueryServiceImpl extends GenericQuery implements CaseQueryService {
    @Override
    public PagedResult<CaseInfoListDto> queryCaseInfoByPaged(CaseInfoQueryCriteria criteria) {
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
