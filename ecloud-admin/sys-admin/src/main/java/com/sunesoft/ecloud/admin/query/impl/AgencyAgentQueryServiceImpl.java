package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyAgentQuerySerivce;
import com.sunesoft.ecloud.adminclient.cretirias.AgentCretiria;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;

/**
 * Created by jzj on 2018/4/11.
 */
public class AgencyAgentQueryServiceImpl extends GenericQuery implements AgencyAgentQuerySerivce{
    @Override
    public PagedResult<AgentDto> findAgentPaged(AgentCretiria cretiria) {
        return null;
    }
}
