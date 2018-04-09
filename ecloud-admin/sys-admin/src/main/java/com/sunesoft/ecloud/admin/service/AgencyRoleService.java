package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 */
public interface AgencyRoleService {

    /**
     * 新增/修改 角色信息
     * @param agencyRoleDto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateRole(AgencyRoleDto agencyRoleDto);

    /**
     * 删除角色
     * @param id 角色id
     * @return 返回操作结果
     */
    TResult delete(UUID id);


    /**
     * 批量删除角色
     * @param ids 角色id
     * @return 返回操作结果
     */
    TResult deleteBatch(UUID... ids);


    /**
     * 检查角色名称是否存在
     * agId 方法内部获取
     * @param id id
     * @param name name
     * @return true :已存在， false ：未存在
     */
    TResult<Boolean> checkRoleNameExist(UUID agId,UUID id,String name);

}
