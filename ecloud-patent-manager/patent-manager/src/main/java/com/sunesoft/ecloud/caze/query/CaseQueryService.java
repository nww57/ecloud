package com.sunesoft.ecloud.caze.query;

import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoListDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageListDto;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public interface CaseQueryService {

    /**
     * 查询案件列表信息
     * @param criteria 查询参数
     * @return 返回查询结果
     */
    PagedResult<CaseInfoListDto> queryCaseInfoByPaged(CaseInfoQueryCriteria criteria);

    /**
     * 根据id查询案件基础信息
     * @param id 案件id
     * @return 返回查询结果
     */
    TResult<CaseInfoListDto> queryCaseBasicInfoById(UUID id);

    /**
     * 查询案件客户要求
     * @param id 案件id
     * @param criteria 查询参数
     * @return 返回查询结果
     */
    PagedResult<CaseCustomerRequestDto> queryCaseCustomerRequestByPaged(UUID id,TCretiria criteria);

    /**
     * 查询案件留言列表
     * @param id 案件id
     * @param criteria 查询参数
     * @return 返回查询结果
     */
    PagedResult<CaseMessageListDto> queryCaseMessageByPaged(UUID id, TCretiria criteria);
}
