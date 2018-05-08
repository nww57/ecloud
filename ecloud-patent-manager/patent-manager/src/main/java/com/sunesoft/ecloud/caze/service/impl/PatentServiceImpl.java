package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caseclient.enums.UpDown;
import com.sunesoft.ecloud.caze.domain.*;
import com.sunesoft.ecloud.caze.repository.*;
import com.sunesoft.ecloud.caze.service.PatentService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        flow.setFlowNode(PatentNode.TOBEIMPROVED.toString());
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
                PatPriorityClaims c = new PatPriorityClaims(info);
                BeanUtil.copyPropertiesIgnoreNull(claimsDto,c );
                claimsList.add(c);
            });
            priorityClaimsRepository.save(claimsList);
        }else{
            //删除所有优先权项
            priorityClaimsRepository.deleteByPatent(patentId);
        }
        //设置申请人
        if(null != dto.getApplicantIdList()){
            applicantRepository.deleteByPatent(patentId);
            List<UUID> applicantIdList = dto.getApplicantIdList();
            List<PatApplicant> applicants = new ArrayList<>();
            PatApplicant applicant ;
            for(int i=0;i<applicantIdList.size();i++){
                applicant = new PatApplicant(info);
                applicant.setSort(i+1);
                applicant.setCustomerApplicantId(applicantIdList.get(i));
                applicants.add(applicant);
            }
            applicantRepository.save(applicants);
        }

        //设置发明人
        if(null != dto.getInventorIdList()){
            inventorRepository.deleteByPatent(patentId);
            List<UUID> inventorIdList = dto.getInventorIdList();
            List<PatInventor> inventors = new ArrayList<>();
            PatInventor inventor;
            for(int i=0;i<inventorIdList.size();i++) {
                inventor = new PatInventor(info);
                inventor.setSort(i+1);
                inventor.setCustomerInventorId(inventorIdList.get(i));
                inventors.add(inventor);
            }
            inventorRepository.save(inventors);
        }

        //设置代理人
        if(null != dto.getAgentIdList()){
           agentRepository.deleteByPatent(patentId);
            List<UUID> agentIdList = dto.getAgentIdList();
            List<PatAgent> agents = new ArrayList<>();
            PatAgent agent;
            for (int i= 0;i<agentIdList.size();i++) {
                agent = new PatAgent(info);
                agent.setSort(i+1);
                agent.setAgencyAgentId(agentIdList.get(i));
                agents.add(agent);
            }
            agentRepository.save(agents);
        }

        //保存客户要求
        PatCustomerDemand demand = customerDemandRepository.findByPatent(patentId);
        if(null == demand){
            demand = new PatCustomerDemand();
            demand.setPatentInfo(info);
        }
        demand.setIsAdvancePublicity(dto.getIsAdvancePublicity());
        demand.setIsFeeReduce(dto.getIsFeeReduce());
        demand.setIsRealTrial(dto.getIsRealTrial());
        demand.setIsReqPriority(dto.getIsReqPriority());
        customerDemandRepository.saveAndFlush(demand);

        //完善信息后，专利节点变换为分配撰写工程师
        info.setPatentNode(PatentNode.ALLOTENGINEER);
        patentInfoRepository.saveAndFlush(info);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdatePatentApplicants(UUID patentId, List<PatApplicantDto> applicantList) {
        if(null == patentId ){
            throw new IllegalArgumentException("参数错误，patentId不能为null");
        }
        PatentInfo info =  patentInfoRepository.findOne(patentId);
        if(null == info){
            throw new IllegalArgumentException("没有找到专利信息patenId="+patentId);
        }
        if(null == applicantList || applicantList.size() == 0){
            throw new IllegalArgumentException("参数错误，申请人信息不能为null");
        }
        //先删除
        applicantRepository.deleteByPatent(patentId);
        List<PatApplicant> applicants = new ArrayList<>();
        PatApplicant applicant;
        for (PatApplicantDto patApplicantDto : applicantList) {
            applicant = new PatApplicant(info);
            BeanUtil.copyPropertiesIgnoreNull(patApplicantDto,applicant);
            applicants.add(applicant);
        }
        applicantRepository.save(applicants);
        return ResultFactory.success();
    }

    @Override
    public TResult sortPatentApplicant(UUID patentApplicantId, UpDown upDown) {
        if(null == patentApplicantId){
            throw new IllegalArgumentException("参数patentApplicantId不能为null");
        }
        PatApplicant applicant = applicantRepository.findOne(patentApplicantId);
        if(Objects.equals(upDown,UpDown.UP)){
            PatApplicant upApplicant = applicantRepository.getUp(applicant.getPatentInfo().getId().toString(),applicant.getSort());
            if(null == upApplicant){
                return new TResult("第一个无法再上移");
            }
            int sort = applicant.getSort();
            applicant.setSort(upApplicant.getSort());
            upApplicant.setSort(sort);
            applicantRepository.save(applicant);
            applicantRepository.save(upApplicant);
        }else{
            PatApplicant downApplicant = applicantRepository.getDown(applicant.getPatentInfo().getId().toString(),applicant.getSort());
            if(null == downApplicant){
                return new TResult("最后一个无法下移");
            }
            int sort = applicant.getSort();
            applicant.setSort(downApplicant.getSort());
            downApplicant.setSort(sort);
            applicantRepository.save(applicant);
            applicantRepository.save(downApplicant);
        }
        return ResultFactory.success();
    }

    @Override
    public TResult deletePatentApplicant(UUID patentApplicantId) {
        if(null == patentApplicantId){
            throw new IllegalArgumentException("参数patentApplicantId不能为null");
        }
        applicantRepository.delete(patentApplicantId);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdatePatentInventors(UUID patentId, List<PatInventorDto> inventorList) {
        if(null == patentId ){
            throw new IllegalArgumentException("参数错误，patentId不能为null");
        }
        PatentInfo info =  patentInfoRepository.findOne(patentId);
        if(null == info){
            throw new IllegalArgumentException("没有找到专利信息patenId="+patentId);
        }
        if(null == inventorList || inventorList.size() == 0){
            throw new IllegalArgumentException("参数错误，发明人信息不能为null");
        }
        //先删除
        inventorRepository.deleteByPatent(patentId);
        List<PatInventor> inventors = new ArrayList<>();
        PatInventor inventor;
        for (PatInventorDto patInventorDto : inventorList) {
            inventor = new PatInventor(info);
            BeanUtil.copyPropertiesIgnoreNull(patInventorDto,inventor);
            inventors.add(inventor);
        }
        inventorRepository.save(inventors);
        return ResultFactory.success();
    }

    @Override
    public TResult sortPatentInventor(UUID patentInventorId, UpDown upDown) {
        if(null == patentInventorId){
            throw new IllegalArgumentException("参数patentInventorId不能为null");
        }
        PatInventor inventor = inventorRepository.findOne(patentInventorId);
        if(Objects.equals(upDown,UpDown.UP)){
            PatInventor upInventor = inventorRepository.getUp(inventor.getPatentInfo().getId().toString(),inventor.getSort());
            if(null == upInventor){
                return new TResult("第一个无法再上移");
            }
            int sort = inventor.getSort();
            inventor.setSort(upInventor.getSort());
            upInventor.setSort(sort);
            inventorRepository.save(inventor);
            inventorRepository.save(upInventor);
        }else{
            PatInventor downInventor = inventorRepository.getDown(inventor.getPatentInfo().getId().toString(),inventor.getSort());
            if(null == downInventor){
                return new TResult("最后一个无法下移");
            }
            int sort = inventor.getSort();
            inventor.setSort(downInventor.getSort());
            downInventor.setSort(sort);
            inventorRepository.save(inventor);
            inventorRepository.save(downInventor);
        }
        return ResultFactory.success();
    }

    @Override
    public TResult deletePatentInventor(UUID patentInventorId) {
        if(null == patentInventorId){
            throw new IllegalArgumentException("参数patentInventorId不能为null");
        }
        inventorRepository.delete(patentInventorId);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdatePatentAgents(UUID patentId, List<PatAgentDto> agentList) {
        if(null == patentId ){
            throw new IllegalArgumentException("参数错误，patentId不能为null");
        }
        PatentInfo info =  patentInfoRepository.findOne(patentId);
        if(null == info){
            throw new IllegalArgumentException("没有找到专利信息patenId="+patentId);
        }
        if(null == agentList || agentList.size() == 0){
            throw new IllegalArgumentException("参数错误，代理人信息不能为null");
        }
        //先删除
        agentRepository.deleteByPatent(patentId);
        List<PatAgent> list = new ArrayList<>();
        PatAgent patAgent;
        for (PatAgentDto patAgentDto : agentList) {
            patAgent = new PatAgent(info);
            BeanUtil.copyPropertiesIgnoreNull(patAgentDto,patAgent);
            list.add(patAgent);
        }
        agentRepository.save(list);
        return ResultFactory.success();
    }

    @Override
    public TResult sortPatentAgent(UUID patentAgentId, UpDown upDown) {
        if(null == patentAgentId){
            throw new IllegalArgumentException("参数patentAgentId不能为null");
        }
        PatAgent agent = agentRepository.findOne(patentAgentId);
        if(Objects.equals(upDown,UpDown.UP)){
            PatAgent upAgent = agentRepository.getUp(agent.getPatentInfo().getId().toString(),agent.getSort());
            if(null == upAgent){
                return new TResult("第一个无法再上移");
            }
            int sort = agent.getSort();
            agent.setSort(upAgent.getSort());
            upAgent.setSort(sort);
            agentRepository.save(agent);
            agentRepository.save(upAgent);
        }else{
            PatAgent downAgent = agentRepository.getDown(agent.getPatentInfo().getId().toString(),agent.getSort());
            if(null == downAgent){
                return new TResult("最后一个无法下移");
            }
            int sort = agent.getSort();
            agent.setSort(downAgent.getSort());
            downAgent.setSort(sort);
            agentRepository.save(agent);
            agentRepository.save(downAgent);
        }
        return ResultFactory.success();
    }

    @Override
    public TResult deletePatentAgent(UUID patentAgentId) {
        if(null == patentAgentId){
            throw new IllegalArgumentException("参数patentAgentId不能为null");
        }
        agentRepository.delete(patentAgentId);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdatePriorityClaims(PatPriorityClaimsDto dto) {
        if(null == dto.getPatentId()){
            throw new IllegalArgumentException("专利id不能为null");
        }
        PatentInfo info = patentInfoRepository.findOne(dto.getPatentId());
        UUID id = dto.getId();
        PatPriorityClaims claims ;
        if(null == id){
            claims = new PatPriorityClaims(info);
        }else{
            claims = priorityClaimsRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(dto,claims);
        priorityClaimsRepository.saveAndFlush(claims);
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
        patentInfo.setPatentNode(PatentNode.WRITING);
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
