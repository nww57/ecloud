package com.sunesoft.ecloud.caze.query;

import com.sunesoft.ecloud.caseclient.criterias.ContractQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.ContractDetailDto;
import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 合同查询
 */
public interface ContractQueryService{

    /**
     * 合同列表查询
     * @param criteria 查询参数
     * @return 返回查询结果
     */
    PagedResult<ContractDto> queryContractPaged(ContractQueryCriteria criteria);


    /**
     * 查询合同详情
     * @param id id
     * @return 返回查询结果
     */
    TResult<ContractDetailDto> getContractDetailById(UUID id);
}
