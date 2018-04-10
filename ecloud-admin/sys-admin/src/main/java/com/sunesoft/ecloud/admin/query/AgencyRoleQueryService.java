package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;

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
    PagedResult<AgencyRoleDto> findAgencyRolePaged(AgencyRoleCriteria criteria);


    /**
     * 根据id获取角色信息
     * @param id 角色id
     * @return 返回查询结果
     */
    TResult<AgencyRoleDto> getAgencyRoleBasicById(UUID id);



    /**
     * 获取机构的id，名称
     * @return 返回查询结果
     */
    ListResult<BasicDto> getAgencyRoleIdName();
}
