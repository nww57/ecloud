package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentType;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 合同案件信息dto
 */
public class ContractPatentInfo {

    private UUID id;

    /**
     * 专利类型
     */
    private PatentType patentType;

    /**
     *案件号
     */
    private String caseNo;

    /**专利名称
     *
     */
    private String patentName;

    /**
     *总费用
     */
    private BigDecimal totalPrice;

    /**
     *官费
     */
    private BigDecimal officialPrice;

    /**
     *代理费
     */
    private BigDecimal agencyPrice;

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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getOfficialPrice() {
        return officialPrice;
    }

    public void setOfficialPrice(BigDecimal officialPrice) {
        this.officialPrice = officialPrice;
    }

    public BigDecimal getAgencyPrice() {
        return agencyPrice;
    }

    public void setAgencyPrice(BigDecimal agencyPrice) {
        this.agencyPrice = agencyPrice;
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
}
