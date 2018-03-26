package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 * 组织架构
 */
public interface AgencyOrganizationService {

    /**
     * 新增/修改 组织架构信息
     * @param agencyOrganizationDto
     * @return
     */
    TResult addOrUpdateOrganization(AgencyOrganizationDto agencyOrganizationDto);


    /**
     * 删除机构
     * @param id
     * @return
     */
    TResult deleteOrganization(UUID id);


    /**
     * 批量删除机构
     * @param id
     * @return
     */
    TResult deleteOrganizationBatch(UUID... id);
}
