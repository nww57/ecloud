package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentType;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class PatentInfoDto {

    private UUID agId;

    private UUID caseId;

    private String patentName;

    private UUID customerId;

    private PatentType patentType;

    private BigDecimal feeReduceRate;

    public PatentInfoDto() {
    }

    public PatentInfoDto(UUID agId,String patentName, UUID customerId, PatentType patentType, BigDecimal feeReduceRate) {
        this.agId = agId;
        this.patentName = patentName;
        this.customerId = customerId;
        this.patentType = patentType;
        this.feeReduceRate = feeReduceRate;
    }

    public PatentInfoDto(UUID agId,UUID caseId, String patentName, UUID customerId, PatentType patentType, BigDecimal feeReduceRate) {
        this.agId = agId;
        this.caseId = caseId;
        this.patentName = patentName;
        this.customerId = customerId;
        this.patentType = patentType;
        this.feeReduceRate = feeReduceRate;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public UUID getCaseId() {
        return caseId;
    }

    public void setCaseId(UUID caseId) {
        this.caseId = caseId;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }

    public BigDecimal getFeeReduceRate() {
        return feeReduceRate;
    }

    public void setFeeReduceRate(BigDecimal feeReduceRate) {
        this.feeReduceRate = feeReduceRate;
    }
}
