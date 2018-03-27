package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleViewDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 企业角色查询
 */
public interface AgencyRoleQueryService {

    /**
     * 查询角色信息
     * @param criteria
     * @return
     */
    Page<AgencyRoleDto> findAgencyRolePaged(AgencyRoleCriteria criteria);

    /**
     * 查询企业下所有角色
     * @param agId 企业id
     * @return 返回查询结果
     */
    ListResult<AgencyRoleDto> getAllAgencyRole(UUID agId);


    /**
     * 根据id获取角色信息
     * @param id 角色id
     * @return 返回查询结果
     */
    TResult<AgencyRoleDto> getAgencyRoleBasicById(UUID id);

    /**
     * 根据id获取角色信息
     * @param id 角色id
     * @return 返回查询结果
     */
    TResult<AgencyRoleViewDto> getAgencyRoleFullById(UUID id);
}
