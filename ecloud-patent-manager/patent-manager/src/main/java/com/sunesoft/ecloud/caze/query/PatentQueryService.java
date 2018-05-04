package com.sunesoft.ecloud.caze.query;

import com.sunesoft.ecloud.caseclient.criterias.PatentQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.PatOfficialFeeDetailDto;
import com.sunesoft.ecloud.caseclient.dto.PatentDetailDto;
import com.sunesoft.ecloud.caseclient.dto.PatentElementDto;
import com.sunesoft.ecloud.caseclient.dto.PatentListDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 专利信息查询
 */
public interface PatentQueryService {

    /**
     * 专利列表查询
     * @param criteria 参数
     * @return 返回查询结果
     */
    PagedResult<PatentListDto> queryPatentPaged(PatentQueryCriteria criteria);


    /**
     * 获取专利详情
     * @param id id
     * @return 返回查询结果
     */
    TResult<PatentDetailDto> getPatentInfoById(UUID id);


    /**
     * 获取专利著录项信息
     * @param id id
     * @return 返回查询结果
     */
    TResult<PatentElementDto> getPatentElement(UUID id);


    /**
     * 获取专利官费信息
     * @param id id
     * @return 返回查询结果
     */
    TResult<PatOfficialFeeDetailDto> getPatentOfficialFeeInfo(UUID id);


}
