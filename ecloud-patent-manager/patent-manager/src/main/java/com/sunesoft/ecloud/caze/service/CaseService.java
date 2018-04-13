package com.sunesoft.ecloud.caze.service;

import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageDto;
import com.sunesoft.ecloud.common.result.TResult;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public interface CaseService {

    /**
     * 创建/修改案件
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCase(CaseInfoDto dto);


    /**
     * 创建/修改客户要求
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCaseCustomerRequest(CaseCustomerRequestDto dto);


    /**
     * 创建/修改 案件留言
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCaseMessage(CaseMessageDto dto);
}
