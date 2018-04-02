package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyOrganizationCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 企业机构查询
 */
public interface AgencyOrganizationQueryService {

    /**
     * 查找组织机构
     * @param criteria 查询参数
     * @return 返回查询信息
     */
    ListResult<AgencyOrganizationDto> findAgencyOrganization(AgencyOrganizationCriteria criteria);


    /**
     * 根据id查询组织机构信息
     * @param id id
     * @return 返回查询结果
     */
    TResult<AgencyOrganizationDto> findAgencyOrganizationBasicById(UUID id);


    /**
     * 获取机构id，名称
     * @return 返回查询结果
     */
    ListResult<BasicDto> getOrganizationIdName();

}