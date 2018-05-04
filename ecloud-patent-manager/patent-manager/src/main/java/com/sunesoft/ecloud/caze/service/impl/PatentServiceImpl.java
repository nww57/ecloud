package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.CreateContractPatentDto;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caze.domain.ContractInfo;
import com.sunesoft.ecloud.caze.domain.PatFlow;
import com.sunesoft.ecloud.caze.domain.PatentInfo;
import com.sunesoft.ecloud.caze.repository.ContractInfoRepository;
import com.sunesoft.ecloud.caze.repository.PatFlowRepository;
import com.sunesoft.ecloud.caze.repository.PatentInfoRepository;
import com.sunesoft.ecloud.caze.service.PatentService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@Service
public class PatentServiceImpl implements PatentService {


    @Autowired
    ContractInfoRepository contractInfoRepository;
    @Autowired
    PatentInfoRepository patentInfoRepository;
    @Autowired
    PatFlowRepository flowRepository;

    @Override
    public TResult generateCaseNo(UUID agId) {
        if(null == agId){
            throw new IllegalArgumentException("无效的agId");
        }
        Object contract = patentInfoRepository.generateCaseNo(agId.toString());
        return new TResult<>(contract);
    }

    @Override
    public TResult addPatent(CreateContractPatentDto dto) {
        //参数检查
        if(null == dto.getAgId()){
            return new TResult("所属企业不能为空");
        }
        if(null == dto.getContractId()){
            return new TResult("所属合同不能为空");
        }
        ContractInfo contractInfo = contractInfoRepository.findOne(dto.getContractId());
        if(null == contractInfo){
            throw new IllegalArgumentException("无效的合同id");
        }
        if(StringUtils.isEmpty(dto.getCaseNo())){
            return new TResult("案件号不能为空");
        }
        if(null == dto.getPatentType()){
            return new TResult("案件类型不能为空");
        }
        if(StringUtils.isEmpty(dto.getPatentName())){
            return new TResult("案件名称不能为空");
        }
        PatentInfo info = new PatentInfo();
        BeanUtil.copyPropertiesIgnoreNull(dto,info);
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
    public TResult deletePatent(UUID id) {
        return null;
    }

    @Override
    public TResult deletePatent(UUID... ids) {
        return null;
    }
}
