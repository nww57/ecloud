package com.sunesoft.ecloud.caze.service;

import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caseclient.enums.UpDown;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Sort;

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
     * 上移/下移
     * @param patentApplicantId 专利申请人id
     * @param upDown 上，下
     * @return 返回操作结果
     */
    TResult sortPatentApplicant(UUID patentId,UUID patentApplicantId, UpDown upDown);

    /**
     * 删除专利申请人
     * @param patentApplicantId 专利申请人信息id
     * @return 返回操作结果
     */
    TResult deletePatentApplicant(UUID patentApplicantId);

    /**
     * 添加/修改 专利发明人信息
     * @param patentId 专利id
     * @param inventorList 发明人信息
     * @return 返回操作结果
     */
    TResult addOrUpdatePatentInventors(UUID patentId, List<PatInventorDto> inventorList);


    /**
     * 上移/下移
     * @param patentInventorId 专利发明人id
     * @param upDown 上，下
     * @return 返回操作结果
     */
    TResult sortPatentInventor(UUID patentInventorId, UpDown upDown);

    /**
     * 删除专利发明人
     * @param patentInventorId 专利发明人id
     * @return 返回操作结果
     */
    TResult deletePatentInventor(UUID patentInventorId);

    /**
     * 添加/修改 专利代理人信息
     * @param patentId 专利id
     * @param agentList 代理人信息
     * @return 返回操作结果
     */
    TResult addOrUpdatePatentAgents(UUID patentId, List<PatAgentDto> agentList);

    /**
     * 上移/下移
     * @param patentAgentId 专利发明人id
     * @param upDown 上，下
     * @return 返回操作结果
     */
    TResult sortPatentAgent(UUID patentAgentId, UpDown upDown);

    /**
     * 删除专利代理人
     * @param patentAgentId 专利代理人id
     * @return 返回操作结果
     */
    TResult deletePatentAgent(UUID patentAgentId);

    /**
     * 新增/修改 优先权项信息
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdatePriorityClaims(PatPriorityClaimsDto dto);


    /**
     * 分配撰写工程师
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult allotEngineer(AllotEngineerDto dto);


}
