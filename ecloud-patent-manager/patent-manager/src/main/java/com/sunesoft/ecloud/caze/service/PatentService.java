package com.sunesoft.ecloud.caze.service;

import com.sunesoft.ecloud.caseclient.dto.CreateContractPatentDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 专利
 */
public interface PatentService {

    /**
     * 获取案件号
     * @param agId
     * @return
     */
    TResult generateCaseNo(UUID agId);

    /**
     * 创建合同案件（专利）信息
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addPatent(CreateContractPatentDto dto);

    /**
     * 删除专利
     * @param id id
     * @return 返回操作结果
     */
    TResult deletePatent(UUID id);

    /**
     * 批量删除专利
     * @param ids id集合
     * @return 返回操作结果
     */
    TResult deletePatent(UUID... ids);
}
