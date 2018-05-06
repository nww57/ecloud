package com.sunesoft.ecloud.caze.service;

import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.List;
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
     * 完善专利信息
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult updatePatent(UpdatePatentDto dto);

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


    /**
     * 添加/修改 专利申请人信息
     * @param patentId 专利id
     * @param applicantList 申请人信息
     * @return 返回操作结果
     */
    TResult addOrUpdatePatentApplicants(UUID patentId, List<PatApplicantDto> applicantList);

    /**
     * 添加/修改 专利发明人信息
     * @param patentId 专利id
     * @param inventorList 发明人信息
     * @return 返回操作结果
     */
    TResult addOrUpdatePatentInventors(UUID patentId, List<PatInventorDto> inventorList);

    /**
     * 添加/修改 专利代理人信息
     * @param patentId 专利id
     * @param agentList 代理人信息
     * @return 返回操作结果
     */
    TResult addOrUpdatePatentAgents(UUID patentId, List<PatAgentDto> agentList);


    /**
     * 分配撰写工程师
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult allotEngineer(AllotEngineerDto dto);
}
