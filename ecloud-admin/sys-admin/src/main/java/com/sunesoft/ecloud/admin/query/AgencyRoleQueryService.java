package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.common.result.ListResult;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
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
     * @param id 企业id
     * @return 返回查询结果
     */
    ListResult<AgencyRoleDto> getAllAgencyRole(UUID id);
}
