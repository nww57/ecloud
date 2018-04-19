package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/12
 */
@Entity
@Table(name = "patent_info")
public class PatentInfo extends BizEntity{



    @ManyToOne
    @JoinColumn(name = "caseId")
    private CaseInfo caseInfo;

    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerId;

    @Column(name = "patentNo")
    private String patentNo;

    @Column(name = "patentName")
    private String patentName;

    @Column(name = "patentType")
    @Enumerated(EnumType.STRING)
    private PatentType patentType;

    @Column(name = "reduceRate")
    private BigDecimal feeReduceRate;

    public PatentInfo() {
    }

    public PatentInfo(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    public CaseInfo getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getPatentNo() {
        return patentNo;
    }

    public void setPatentNo(String patentNo) {
        this.patentNo = patentNo;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
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
