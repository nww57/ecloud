package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.PatentQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.PatOfficialFeeDetailDto;
import com.sunesoft.ecloud.caseclient.dto.PatentDetailDto;
import com.sunesoft.ecloud.caseclient.dto.PatentElementDto;
import com.sunesoft.ecloud.caseclient.dto.PatentListDto;
import com.sunesoft.ecloud.caze.query.PatentQueryService;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
@Service
public class PatentQueryServiceImpl extends GenericQuery implements PatentQueryService {
    @Override
    public PagedResult<PatentListDto> queryPatentPaged(PatentQueryCriteria criteria) {
        return null;
    }

    @Override
    public TResult<PatentDetailDto> getPatentInfoById(UUID id) {
        return null;
    }

    @Override
    public TResult<PatentElementDto> getPatentElement(UUID id) {
        return null;
    }

    @Override
    public TResult<PatOfficialFeeDetailDto> getPatentOfficialFeeInfo(UUID id) {
        return null;
    }
}
