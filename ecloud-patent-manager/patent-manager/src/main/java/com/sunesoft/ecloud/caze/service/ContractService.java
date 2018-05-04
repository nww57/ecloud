package com.sunesoft.ecloud.caze.service;

import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 合同
 */
public interface ContractService {

    /**
     * 获取合同号
     * @param agId
     * @return
     */
    TResult generateContractNo(UUID agId);

    /**
     * 创建/修改合同
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateContract(ContractDto dto);

    /**
     * 删除合同信息
     * @param id id
     * @return 返回操作结果
     */
    TResult deleteContract(UUID id);

    /**
     * 删除合同信息
     * @param ids 参数
     * @return 返回操作结果
     */
    TResult deleteContract(UUID... ids);
}
