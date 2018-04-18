package com.sunesoft.ecloud.caze.service.impl;


import com.sunesoft.ecloud.adminclient.clientService.UserServiceClient;
import com.sunesoft.ecloud.caseclient.CaseType;
import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caze.domain.*;
import com.sunesoft.ecloud.caze.repository.*;
import com.sunesoft.ecloud.caze.service.CaseService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    CaseInfoColumnConfigureRepository columnConfigureRepository;
    @Autowired
    UserServiceClient userServiceClient;


    @Override
    public TResult addOrUpdateCase(CaseInfoDto dto) {
        //检查参数
        if (null == dto.getId() && null == dto.getAgId()) {
            throw new IllegalArgumentException("企业id不能为null");
        }
        if (StringUtils.isEmpty(dto.getCaseCreatorName())) {
            throw new IllegalArgumentException("未设置立案人姓名");
        }
        if (null == dto.getCaseType()) {
            return new TResult("请选择案件类型");
        }
        if (null == dto.getFeeReduceRate()) {
            return new TResult("请选择费减比例");
        }
        if (null == dto.getCustomerId()) {
            return new TResult("请选择所属客户客户");
        }
        if (StringUtils.isEmpty(dto.getCaseName())) {
            return new TResult("请填写案件案件名称");
        }
        UUID caseId = dto.getId();
        CaseInfo caseInfo;
        if (null == caseId) {
            caseInfo = new CaseInfo();
        } else {
            caseInfo = caseRepository.findOne(caseId);
        }
        BeanUtil.copyPropertiesIgnoreNull(dto, caseInfo);
        caseInfo = caseRepository.saveAndFlush(caseInfo);
        if (null == caseId) {
            CaseType caseType = caseInfo.getCaseType();
            // 创建专利
            if (Objects.equals(CaseType.INVENTION_PATENT, caseType)) {
                createPatent(caseInfo, new PatentInfoDto(caseInfo.getAgId(), caseInfo.getCaseName(), caseInfo.getCustomerId(), PatentType.INVENTION_PATENT, caseInfo.getFeeReduceRate()));
            } else if (Objects.equals(CaseType.UTILITYMODEL_PATENT, caseType)) {
                createPatent(caseInfo, new PatentInfoDto(caseInfo.getAgId(), caseInfo.getCaseName(), caseInfo.getCustomerId(), PatentType.UTILITYMODEL_PATENT, caseInfo.getFeeReduceRate()));
            } else if (Objects.equals(CaseType.DESIGN_PATENT, caseType)) {
                createPatent(caseInfo, new PatentInfoDto(caseInfo.getAgId(), caseInfo.getCaseName(), caseInfo.getCustomerId(), PatentType.DESIGN_PATENT, caseInfo.getFeeReduceRate()));
            } else if (Objects.equals(CaseType.SAMEDAYAPPLY_PATENT, caseType)) {
                createPatent(caseInfo, new PatentInfoDto(caseInfo.getAgId(), caseInfo.getCaseName(), caseInfo.getCustomerId(), PatentType.INVENTION_PATENT, caseInfo.getFeeReduceRate()));
                createPatent(caseInfo, new PatentInfoDto(caseInfo.getAgId(), caseInfo.getCaseName(), caseInfo.getCustomerId(), PatentType.UTILITYMODEL_PATENT, caseInfo.getFeeReduceRate()));
            } else {
                throw new IllegalArgumentException("无效的案件类型");
            }
        }
        return new TResult<>(caseInfo.getId());
    }

    @Override
    public TResult deleteCase(UUID... ids) {
        if (null == ids || ids.length == 0) {
            throw new IllegalArgumentException("案件id不能为null");
        }
        //逻辑删除
        caseRepository.deleteBatch(ids);
        //todo 删除专利信息
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdateCaseCustomerRequest(CaseCustomerRequestDto dto) {

        UUID id = dto.getId();
        CaseCustomerRequest request;
        if (null == id) {
            UUID caseId = dto.getCaseId();
            if (null == caseId) {
                throw new IllegalArgumentException("案件id不能为null");
            }
            CaseInfo caseInfo = caseRepository.findOne(caseId);
            if (null == caseInfo) {
                throw new IllegalArgumentException("无效的案件id");
            }
            request = new CaseCustomerRequest();
            request.setCaseInfo(caseInfo);
        } else {
            request = caseCustomerRequestRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(dto, request);
        caseCustomerRequestRepository.saveAndFlush(request);
        return ResultFactory.success();
    }

    @Override
    public TResult deleteCaseCustomerRequest(UUID... id) {
        if(null ==id || id.length ==0){
            throw new IllegalArgumentException("参数不能为null");
        }
        caseCustomerRequestRepository.deleteBatch(id);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdateCaseMessage(CaseMessageDto dto) {
        UUID caseId = dto.getCaseId();
        if (null == caseId) {
            throw new IllegalArgumentException("案件id不能为null");
        }
        CaseInfo caseInfo = caseRepository.findOne(caseId);
        if (null == caseInfo) {
            throw new IllegalArgumentException("无效的案件id");
        }
        if (null == dto.getMessagerId() || StringUtils.isEmpty(dto.getMessagerRealName())) {
            throw new IllegalArgumentException("未设置留言人信息");
        }
        CaseMessage message = new CaseMessage();
        message.setCaseInfo(caseInfo);
        message.setContent(dto.getContent());
        message.setMessagerId(dto.getMessagerId());
        message.setMessagerRealName(dto.getMessagerRealName());
        message.setMessagerRoleName(dto.getMessagerRoleName());
        caseMessageRepository.saveAndFlush(message);
        return ResultFactory.success();
    }

    @Override
    public TResult configureCaseQueryColumn(CaseInfoColumnConfigureDto dto) {
        if (null == dto.getUserId() || StringUtils.isEmpty(dto.getConfigure())) {
            throw new IllegalArgumentException("参数不能为null");
        }
        CaseInfoColumnConfigure configureEntity = new CaseInfoColumnConfigure();
        configureEntity.setUserId(dto.getUserId());
        configureEntity.setConfigure(dto.getConfigure());
        columnConfigureRepository.saveAndFlush(configureEntity);
        return ResultFactory.success();
    }

    private void createPatent(CaseInfo caseInfo, PatentInfoDto patentInfoDto) {
        if (null == caseInfo) {
            throw new IllegalArgumentException("案件对象不能为空");
        }
        PatentInfo patentInfo = new PatentInfo(caseInfo);
        BeanUtil.copyPropertiesIgnoreNull(patentInfoDto, patentInfo);
        patentRepository.saveAndFlush(patentInfo);
    }

}
