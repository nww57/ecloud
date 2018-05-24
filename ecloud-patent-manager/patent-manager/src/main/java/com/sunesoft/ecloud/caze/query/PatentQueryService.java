package com.sunesoft.ecloud.caze.query;

import com.sunesoft.ecloud.caseclient.criterias.PatentNodeQueryCriteria;
import com.sunesoft.ecloud.caseclient.criterias.PatentQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.Map;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 专利信息查询
 */
public interface PatentQueryService {

    /**
     * 获取各专利节点所拥有专利的个数
     * @param agId 企业id
     * @return 返回查询结果
     */
    TResult<Map<PatentNode,Integer>> getPatentNodeCount(UUID agId);

    /**
     * 获取用户流程节点信息数量
     * @param userId 用户id
     * @return 返回节点信息
     */
    TResult<Map<PatentNode,Integer>> getUserPatentNodeCount(UUID userId);

    /**
     * 获取用户设置的查询条件
     * @param userId 用户id
     * @return 返回查询结果
     */
    TResult<PatentQueryConfigDto> getUserPatentQueryConfig(UUID userId);


    /**
     * 获取某一节点下的专利基础信息
     * @param criteria 查询参数
     * @return 返回查询结果
     */
    PagedResult<PatentBasicDto> getPatentBasicInfoByPatentNode(PatentNodeQueryCriteria criteria);


    /**
     * 专利列表查询
     * @param criteria 参数
     * @return 返回查询结果
     */
    PagedResult<PatentListDto> queryPatentPaged(PatentQueryCriteria criteria);

    /**
     * 获取专利详情的基础信息
     * @param id 专利id
     * @return 返回查询结果
     */
    TResult<PatentDetailBasicDto> getPatentDetailBasicInfo(UUID id);

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
    ListResult<PatOfficialFeeDetailDto> getPatentOfficialFeeInfo(UUID id);

    /**
     * 获取专利申请人列表
     * @param patentId 专利id
     * @return 返回查询结果
     */
    ListResult<PatApplicantDto> getPatentApplicants(UUID patentId);

    /**
     * 获取专利发明人信息列表
     * @param patentId 专利id
     * @return 返回查询结果
     */
    ListResult<PatInventorDto> getPatentInventors(UUID patentId);

    /**
     * 获取专利代理人信息列表
     * @param patentId 专利id
     * @return 返回查询结果
     */
    ListResult<PatAgentDto> getPatentAgents(UUID patentId);

    /**
     * 获取专利优先权项信息列表
     * @param patentId 专利id
     * @return 返回查询结果
     */
    ListResult<PatPriorityClaimsDto> getPatentPriorityClaims(UUID patentId);


    /**
     * 查询专利的流程信息
     * @param patentId 专利id
     * @return 返回查询结果
     */
    PagedResult<PatentFlowDto> getPatentFlowInfo(UUID patentId);
}
