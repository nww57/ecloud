package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentType;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 创建合同案件dto
 */
public class CreateContractPatentDto {

    private UUID id;

    /**
     * 所属企业
     */
    private UUID agId;

    /**
     * 创建者
     */
    private UUID creatorId;

    /**
     * 所属合同
     */
    private UUID contractId;

    /**
     * 专利类型
     */
    private PatentType patentType;

    /**
     * 案件号
     */
    private String caseNo;

    /**
     * 专利名称
     */
    private String patentName;

    /**
     * 是否同日申请
     */
    private boolean isApplicationSameDay;

    /**
     * 同日申请案件号
     */
    private String applicationSameDayCaseNo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public boolean isApplicationSameDay() {
        return isApplicationSameDay;
    }

    public void setApplicationSameDay(boolean applicationSameDay) {
        isApplicationSameDay = applicationSameDay;
    }

    public String getApplicationSameDayCaseNo() {
        return applicationSameDayCaseNo;
    }

    public void setApplicationSameDayCaseNo(String applicationSameDayCaseNo) {
        this.applicationSameDayCaseNo = applicationSameDayCaseNo;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UUID creatorId) {
        this.creatorId = creatorId;
    }
}
