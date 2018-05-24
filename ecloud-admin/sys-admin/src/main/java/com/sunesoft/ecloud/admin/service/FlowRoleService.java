package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.common.result.TResult;

import java.util.List;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 */
public interface FlowRoleService {

    /**
     * 设置流程角色的 用户
     * @param roleId 流程角色id
     * @param userIdList 用户id
     * @return 返回操作结果
     */
    TResult editRoleUser(UUID roleId, List<UUID> userIdList);
}
