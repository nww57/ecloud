package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyOrganizationCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 企业机构查询
 */
public interface AgencyOrganizationQueryServicce {

    /**
     * 查找组织机构
     * @param criteria 查询参数
     * @return 返回查询信息
     */
    TResult<AgencyOrganizationDto> findAgencyOrganization(AgencyOrganizationCriteria criteria);

}