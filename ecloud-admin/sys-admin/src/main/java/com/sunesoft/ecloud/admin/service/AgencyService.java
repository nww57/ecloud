package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public interface AgencyService {


    /**
     * 新增/修改 企业信息
     * @param agencyDto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateAgency(AgencyDto agencyDto);


    /**
     * 修改 企业基本信息
     * @return 返回操作结果
     */
    TResult updateAgencyBasicInfo(AgencyBasicDto AgencyBasicDto);

    /**
     * 删除企业信息
     * @param id 企业id
     * @return 返回操作结果
     */
    TResult delete(UUID id);

    /**
     * 批量删除企业信息
     * @param ids 企业id
     * @return 返回操作结果
     */
    TResult deleteBatch(UUID... ids);


    /**
     * 检查机构编码是否存在
     * @param code code
     * @return true：已存在 false :不存在
     */
    TResult<Boolean> checkAgencyCodeExist(String code);

}
