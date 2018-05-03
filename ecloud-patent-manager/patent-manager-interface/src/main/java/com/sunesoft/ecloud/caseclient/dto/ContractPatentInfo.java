package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.PatentType;

import java.math.BigDecimal;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 合同案件信息dto
 */
public class ContractPatentInfo {

    private PatentType patentType;

    private String caseNo;

    private String patentName;

    private BigDecimal totalPrice;

    private BigDecimal officialPrice;

    private BigDecimal agencyPrice;

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
}
