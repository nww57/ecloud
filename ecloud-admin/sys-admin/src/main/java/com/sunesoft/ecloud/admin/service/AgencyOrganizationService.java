package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 组织架构Service
 */
public interface AgencyOrganizationService {

    /**
     * 新增/修改 组织架构信息
     * @param agencyOrganizationDto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateOrganization(AgencyOrganizationDto agencyOrganizationDto);


    /**
     * 删除机构
     * @param id 机构id
     * @return 返回操作结果
     */
    TResult delete(UUID id);


    /**
     * 批量删除机构
     * @param ids 机构id
     * @return 返回操作结果
     */
    TResult deleteBatch(UUID... ids);


    /**
     * 检查企业下机构名称是否存在
     * param agId 企业id在方法内部获取
     * @param id 自身id
     * @param name name
     * @return true :已存在 false :不存在
     */
    TResult<Boolean> checkOrganizationNameExist(UUID id,String name);


    /**
     * 检查企业下机构编码是否存在
     * param agId 企业id在方法内部获取
     * @param id  自身id
     * @param code code
     * @return true :已存在 false :不存在
     */
    TResult<Boolean> checkOrganizationCodeExist(UUID id,String code);

}
