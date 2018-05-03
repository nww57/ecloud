package com.sunesoft.ecloud.caze.service;

import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoColumnConfigureDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 * 案件
 */
public interface CaseService {

    /**
     * 创建/修改案件
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCase(CaseInfoDto dto);


    /**
     * 设置案件费减比列
     * @param caseId
     * @param feeReduceRate
     * @return
     */
    TResult setCaseFeeReduceRate(UUID caseId, BigDecimal feeReduceRate);

    /**
     * 删除案件
     * @param ids 案件id
     * @return 返回操作结果
     */
    TResult deleteCase(UUID... ids);


    /**
     * 创建/修改客户要求
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCaseCustomerRequest(CaseCustomerRequestDto dto);

    /**
     * 删除客户要求
     * @param id id
     * @return 返回操作结果
     */
    TResult deleteCaseCustomerRequest(UUID... id);


    /**
     * 创建/修改 案件留言
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCaseMessage(CaseMessageDto dto);

    /**
     * 删除案件留言
     * @param userId 留言用户id
     * @param id 留言id
     * @return 返回操作结果
     */
    TResult deleteCaseMessage(UUID userId,UUID... id);

    /**
     * 配置案件查询列表项
     * @param dto 配置参数
     * @return 返回操作结果
     */
    TResult configureCaseQueryColumn(CaseInfoColumnConfigureDto dto);
}
