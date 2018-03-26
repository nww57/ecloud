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
     * @param agencyRoleDto
     * @return
     */
    TResult addOrUpdateRole(AgencyRoleDto agencyRoleDto);

    /**
     * 删除角色
     * @param id
     * @return
     */
    TResult delete(UUID... id);




}
