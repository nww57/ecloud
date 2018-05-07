package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caze.domain.*;
import com.sunesoft.ecloud.caze.repository.*;
import com.sunesoft.ecloud.caze.service.PatentService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@Service
@Transactional
public class PatentServiceImpl implements PatentService {


    @Autowired
    ContractInfoRepository contractInfoRepository;
    @Autowired
    PatentInfoRepository patentInfoRepository;
    @Autowired
    PatFlowRepository flowRepository;
    @Autowired
    PatCustomerDemandRepository customerDemandRepository;
    @Autowired
    PatPriorityClaimsRepository priorityClaimsRepository;
    @Autowired
    PatApplicantRepository applicantRepository;
    @Autowired
    PatInventorRepository inventorRepository;
    @Autowired
    PatAgentRepository agentRepository;

    @Override
    public TResult generateCaseNo(UUID agId) {
        if (null == agId) {
            throw new IllegalArgumentException("无效的agId");
        }
        Object contract = patentInfoRepository.generateCaseNo(agId.toString());
        return new TResult<>(contract);
    }

    @Override
    public TResult addPatent(CreateContractPatentDto dto) {
        //参数检查
        if (null == dto.getAgId()) {
            return new TResult("所属企业不能为空");
        }
        if (null == dto.getContractId()) {
            return new TResult("所属合同不能为空");
        }
        ContractInfo contractInfo = contractInfoRepository.findOne(dto.getContractId());
        if (null == contractInfo) {
            throw new IllegalArgumentException("无效的合同id");
        }
        if (StringUtils.isEmpty(dto.getCaseNo())) {
            return new TResult("案件号不能为空");
        }
        if(!Objects.equals(dto.getCaseNo(),generateCaseNo(dto.getAgId()).getResult())){
            return new TResult("案件号已经更改，请重新创建");
        }
        if (null == dto.getPatentType()) {
            return new TResult("案件类型不能为空");
        }
        if (StringUtils.isEmpty(dto.getPatentName())) {
            return new TResult("案件名称不能为空");
        }
        PatentInfo info = new PatentInfo();
        BeanUtil.copyPropertiesIgnoreNull(dto, info);
        info.setContractInfo(contractInfo);
        patentInfoRepository.saveAndFlush(info);
        //记录节点
        PatFlow flow = new PatFlow();
        flow.setFlowNode(PatentNode.NEW.toString());
        flow.setNodeStartDate(LocalDate.now());
        flow.setPatentInfo(info);
        flowRepository.saveAndFlush(flow);
        return ResultFactory.success();
    }

    @Override
    public TResult updatePatent(UpdatePatentDto dto) {
        UUID patentId = dto.getPatentId();
        if (null == patentId) {
            throw new IllegalArgumentException("无效的参数patentId");
        }
        PatentInfo info = patentInfoRepository.findOne(patentId);
        if (null == info) {
            throw new IllegalArgumentException("无效的参数patentId");
        }
        if (StringUtils.isNotEmpty(dto.getPatentName())) {
            info.setPatentName(dto.getPatentName());
        }
        if (null != dto.getTechDomain()) {
            info.setTechDomain(dto.getTechDomain());
        }
        patentInfoRepository.saveAndFlush(info);
        //保存客户要求
        PatCustomerDemand demand = customerDemandRepository.findByPatent(patentId);
        if(null == demand){
            demand = new PatCustomerDemand();
        }
        demand.setPatentInfo(info);
        demand.setIsAdvancePublicity(dto.getIsAdvancePublicity());
        demand.setIsFeeReduce(dto.getIsFeeReduce());
        demand.setIsRealTrial(dto.getIsRealTrial());
        demand.setIsReqPriority(dto.getIsReqPriority());
        customerDemandRepository.saveAndFlush(demand);
        //如果勾选了优先权项，保存优先权项
        if (dto.getIsReqPriority()) {
            //设置优先权项
            if (null == dto.getPriorityClaimsList() || dto.getPriorityClaimsList().size() == 0) {
                throw new IllegalArgumentException("请填写优先权项");
            }
            //先删除所有优先权项
            priorityClaimsRepository.deleteByPatent(patentId);
            List<PatPriorityClaimsDto> claimsDtoList = dto.getPriorityClaimsList();
            List<PatPriorityClaims> claimsList = new ArrayList<>();
            claimsDtoList.forEach(claimsDto -> {
                PatPriorityClaims c = new PatPriorityClaims();
                BeanUtil.copyPropertiesIgnoreNull(claimsDto,c );
                claimsList.add(c);
            });
            priorityClaimsRepository.save(claimsList);
        }else{
            //删除所有优先权项
            priorityClaimsRepository.deleteByPatent(patentId);
        }
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdatePatentApplicants(UUID patentId, List<PatApplicantDto> applicantList) {
        if(null == patentId ){
            throw new IllegalArgumentException("参数错误，patentId不能为null");
        }
        if(null == applicantList || applicantList.size() == 0){
            throw new IllegalArgumentException("参数错误，申请人信息不能为null");
        }
        //先删除
        applicantRepository.deleteByPatent(patentId);
        List<PatApplicant> applicants = new ArrayList<>();
        PatApplicant applicant;
        for (PatApplicantDto patApplicantDto : applicantList) {
            applicant = new PatApplicant();
            BeanUtil.copyPropertiesIgnoreNull(patApplicantDto,applicant);
            applicants.add(applicant);
        }
        applicantRepository.save(applicants);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdatePatentInventors(UUID patentId, List<PatInventorDto> inventorList) {
        if(null == patentId ){
            throw new IllegalArgumentException("参数错误，patentId不能为null");
        }
        if(null == inventorList || inventorList.size() == 0){
            throw new IllegalArgumentException("参数错误，发明人信息不能为null");
        }
        //先删除
        inventorRepository.deleteByPatent(patentId);
        List<PatInventor> inventors = new ArrayList<>();
        PatInventor inventor;
        for (PatInventorDto patInventorDto : inventorList) {
            inventor = new PatInventor();
            BeanUtil.copyPropertiesIgnoreNull(patInventorDto,inventor);
            inventors.add(inventor);
        }
        inventorRepository.save(inventors);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdatePatentAgents(UUID patentId, List<PatAgentDto> agentList) {
        if(null == patentId ){
            throw new IllegalArgumentException("参数错误，patentId不能为null");
        }
        if(null == agentList || agentList.size() == 0){
            throw new IllegalArgumentException("参数错误，代理人信息不能为null");
        }
        //先删除
        agentRepository.deleteByPatent(patentId);
        List<PatAgent> list = new ArrayList<>();
        PatAgent patAgent;
        for (PatAgentDto patAgentDto : agentList) {
            patAgent = new PatAgent();
            BeanUtil.copyPropertiesIgnoreNull(patAgentDto,patAgent);
            list.add(patAgent);
        }
        agentRepository.save(list);
        return ResultFactory.success();
    }

    @Override
    public TResult allotEngineer(AllotEngineerDto dto) {
        if(null == dto.getPatentId()){
            throw new IllegalArgumentException("专利id不能为null");
        }
        if(null == dto.getEngineerId()){
            return new TResult("未分配工程师");
        }
        PatentInfo patentInfo = patentInfoRepository.findOne(dto.getPatentId());
        patentInfo.setEngineerId(dto.getEngineerId());
        patentInfo.setWriteExpiryDate(dto.getWriteExpiryDate());
        return ResultFactory.success();
    }

    @Override
    public TResult deletePatent(UUID id) {
        patentInfoRepository.deleteBatch(id);
        return ResultFactory.success();
    }

    @Override
    public TResult deletePatent(UUID... ids) {
        patentInfoRepository.deleteBatch(ids);
        return ResultFactory.success();
    }
}
