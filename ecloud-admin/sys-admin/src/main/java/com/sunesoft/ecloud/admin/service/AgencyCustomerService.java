package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 */
public interface AgencyCustomerService {

    /**
     * 新增/修改 客户信息
     * @param agencyCustomerDto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateAgencyCustoemr(AgencyCustomerDto agencyCustomerDto);

    /**
     * 删除操作
     * @param id id
     * @return 返回操作结果
     */
    TResult delete(UUID id);

    /**
     * 批量删除操作
     * @param ids ids
     * @return 返回操作结果
     */
    TResult deleteBatch(UUID... ids);


}
