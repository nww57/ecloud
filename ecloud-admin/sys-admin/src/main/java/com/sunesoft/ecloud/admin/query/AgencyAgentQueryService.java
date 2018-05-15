package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgentCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.List;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 */
public interface AgencyAgentQueryService {

    /**
     * 查询代理人信息列表
     * @param criteria 查询参数
     * @return 返回查询结果
     */
    PagedResult<AgentDto> findAgentPaged(AgentCriteria criteria);

    /**
     * 根据id查找代理人信息
     * @param id id
     * @return 返回查询结果
     */
    TResult<AgentDto> findAgentById(UUID id);


    /**
     * 根据id集合查找代理人信息
     * @param idList id集合
     * @return 返回查询结果
     */
    ListResult<AgentDto> findAgentByIdList(List<UUID> idList);
}
