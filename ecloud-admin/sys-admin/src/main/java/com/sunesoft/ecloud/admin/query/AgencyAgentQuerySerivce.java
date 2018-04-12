package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgentCretiria;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.common.result.PagedResult;

/**
 * Created by jzj on 2018/4/11.
 */
public interface AgencyAgentQuerySerivce {

    PagedResult<AgentDto> findAgentPaged(AgentCretiria cretiria);
}
