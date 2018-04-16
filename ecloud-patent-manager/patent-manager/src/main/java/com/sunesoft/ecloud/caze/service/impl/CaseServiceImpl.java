package com.sunesoft.ecloud.caze.service.impl;


import com.sunesoft.ecloud.caseclient.CaseType;
import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageDto;
import com.sunesoft.ecloud.caseclient.dto.PatentInfoDto;
import com.sunesoft.ecloud.caze.domain.CaseCustomerRequest;
import com.sunesoft.ecloud.caze.domain.CaseInfo;
import com.sunesoft.ecloud.caze.domain.CaseMessage;
import com.sunesoft.ecloud.caze.domain.PatentInfo;
import com.sunesoft.ecloud.caze.repository.CaseCustomerRequestRepository;
import com.sunesoft.ecloud.caze.repository.CaseInfoRepository;
import com.sunesoft.ecloud.caze.repository.CaseMessageRepository;
import com.sunesoft.ecloud.caze.repository.PatentInfoRepository;
import com.sunesoft.ecloud.caze.service.CaseService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
@Service
@Transactional
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseInfoRepository caseRepository;
    @Autowired
    PatentInfoRepository patentRepository;
    @Autowired
    CaseMessageRepository caseMessageRepository;
    @Autowired
    CaseCustomerRequestRepository caseCustomerRequestRepository;


    @Override
    public TResult addOrUpdateCase(CaseInfoDto dto) {
        //TODO 检查参数
        UUID caseId = dto.getId();
        CaseInfo caseInfo ;
        if(null == caseId){
            caseInfo = new CaseInfo();
        }else{
            caseInfo = caseRepository.findOne(caseId);
        }
        BeanUtil.copyPropertiesIgnoreNull(dto,caseInfo);
        caseInfo = caseRepository.saveAndFlush(caseInfo);
        if(null == caseId){
            CaseType caseType = caseInfo.getCaseType();
            // 创建专利
            if(Objects.equals(CaseType.INVENTION_PATENT,caseType)){
                createPatent(caseInfo,new PatentInfoDto(caseInfo.getAgId(),caseInfo.getCaseName(),caseInfo.getCustomerId(),PatentType.INVENTION_PATENT,caseInfo.getFeeReduceRate()));
            }else if(Objects.equals(CaseType.UTILITYMODEL_PATENT,caseType)){
                createPatent(caseInfo,new PatentInfoDto(caseInfo.getAgId(),caseInfo.getCaseName(),caseInfo.getCustomerId(),PatentType.UTILITYMODEL_PATENT,caseInfo.getFeeReduceRate()));
            }else if(Objects.equals(CaseType.DESIGN_PATENT,caseType)){
                createPatent(caseInfo,new PatentInfoDto(caseInfo.getAgId(),caseInfo.getCaseName(),caseInfo.getCustomerId(),PatentType.DESIGN_PATENT,caseInfo.getFeeReduceRate()));
            }else if(Objects.equals(CaseType.SAMEDAYAPPLY_PATENT,caseType)){
                createPatent(caseInfo,new PatentInfoDto(caseInfo.getAgId(),caseInfo.getCaseName(),caseInfo.getCustomerId(),PatentType.INVENTION_PATENT,caseInfo.getFeeReduceRate()));
                createPatent(caseInfo,new PatentInfoDto(caseInfo.getAgId(),caseInfo.getCaseName(),caseInfo.getCustomerId(),PatentType.UTILITYMODEL_PATENT,caseInfo.getFeeReduceRate()));
            }else{
                throw new IllegalArgumentException("无效的案件类型");
            }
        }
        return new TResult<>(caseInfo.getId());
    }

    @Override
    public TResult addOrUpdateCaseCustomerRequest(CaseCustomerRequestDto dto) {

        UUID id = dto.getId();
        CaseCustomerRequest request ;
        if(null == id){
            UUID caseId = dto.getCaseId();
            if(null == caseId){
                throw new IllegalArgumentException("案件id不能为null");
            }
            CaseInfo caseInfo = caseRepository.findOne(caseId);
            if(null == caseInfo){
                throw new IllegalArgumentException("无效的案件id");
            }
            request = new CaseCustomerRequest();
            request.setCaseInfo(caseInfo);
        }else{
            request = caseCustomerRequestRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(dto,request);
        caseCustomerRequestRepository.saveAndFlush(request);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdateCaseMessage(CaseMessageDto dto) {
        UUID caseId = dto.getCaseId();
        if(null == caseId){
            throw new IllegalArgumentException("案件id不能为null");
        }
        CaseInfo caseInfo = caseRepository.findOne(caseId);
        if(null == caseInfo){
            throw new IllegalArgumentException("无效的案件id");
        }
        CaseMessage message = new CaseMessage();
        message.setCaseInfo(caseInfo);
        message.setContent(dto.getContent());
        message.setMessagerRealName("业务顾问");
        message.setMessagerRoleName("张三");
        caseMessageRepository.saveAndFlush(message);
        return ResultFactory.success();
    }

    private void createPatent(CaseInfo caseInfo,PatentInfoDto patentInfoDto){
        if(null == caseInfo){
            throw new IllegalArgumentException("案件对象不能为空");
        }
        PatentInfo patentInfo = new PatentInfo(caseInfo);
        BeanUtil.copyPropertiesIgnoreNull(patentInfoDto, patentInfo);
        patentRepository.saveAndFlush(patentInfo);
    }

}
