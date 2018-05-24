package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.FlowRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.FlowRoleUserDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 */
public interface FlowRoleQueryService {

    /**
     * 查询流程角色信息
     * @param criteria 查询条件
     * @return 返回查询结果
     */
    PagedResult<FlowRoleUserDto> findFlowRoleInfoByPaged(FlowRoleCriteria criteria);

    /**
     * 根据角色id获取详情
     * @param roleId 角色id
     * @return 返回查询结果
     */
    TResult<FlowRoleUserDto> getFlowRoleUserInfoById(UUID roleId);
}
