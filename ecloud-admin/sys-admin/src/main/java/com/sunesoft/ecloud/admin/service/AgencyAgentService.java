package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 代理人管理
 */
public interface AgencyAgentService {

    /**
     * 添加或修改代理人信息
     * @param agentDto 操作参数
     * @return 返回操作结果
     */
    TResult addOrUpdateAgencyAgent(AgentDto agentDto);


    /**
     * 删除代理人信息
     * @param id id
     * @return 返回操作结果
     */
    TResult deleteAgencyAgent(UUID... id);
}
