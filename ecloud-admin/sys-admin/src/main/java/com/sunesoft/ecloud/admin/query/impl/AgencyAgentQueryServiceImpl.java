package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAgent;
import com.sunesoft.ecloud.admin.query.AgencyAgentQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgentCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 */
@Service
public class AgencyAgentQueryServiceImpl extends GenericQuery implements AgencyAgentQueryService {

    @Override
    public PagedResult<AgentDto> findAgentPaged(AgentCriteria criteria) {
        if(null == criteria.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        Map<String,Object> param = new HashMap<>();
        param.put("a.agId",criteria.getAgId());
        if(StringUtils.isNotEmpty(criteria.getName())){
            param.put("a.name","%"+criteria.getName()+"%");
        }
        if(StringUtils.isNotEmpty(criteria.getName())){
            param.put("a.licenseCode","%"+criteria.getLicenseCode()+"%");
        }
        if(StringUtils.isNotEmpty(criteria.getName())){
            param.put("a.mobile","%"+criteria.getMobile()+"%");
        }
        SqlBuilder<AgentDto> dtoBuilder = HSqlBuilder.hFrom(AgencyAgent.class, "a")
                .where(param)
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .select(AgentDto.class);
        return this.queryPaged(dtoBuilder);
    }

    @Override
    public TResult<AgentDto> findAgentById(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("id不能为null");
        }
        SqlBuilder<AgentDto> dtoBuilder = HSqlBuilder.hFrom(AgencyAgent.class, "a")
                .where("id",id)
                .select(AgentDto.class);
        return new TResult<>(queryForObject(dtoBuilder));
    }
}
