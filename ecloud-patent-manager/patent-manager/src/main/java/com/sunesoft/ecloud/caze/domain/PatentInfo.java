package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/12
 */
@Entity
@Table(name = "patent_info")
public class PatentInfo extends BizEntity{


    /**
     * 所属案件
     */
    @ManyToOne
    @JoinColumn(name = "caseId")
    private CaseInfo caseInfo;

    /**
     * 所属客户
     */
    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerId;

    /**
     * 专利号
     */
    @Column(name = "patentNo")
    private String patentNo;

    /**
     * 专利名称
     */
    @Column(name = "patentName")
    private String patentName;

    /**
     * 专利类型
     */
    @Column(name = "patentType")
    @Enumerated(EnumType.STRING)
    private PatentType patentType;

    /**
     * 费减比例
     */
    @Column(name = "reduceRate")
    private BigDecimal feeReduceRate;

    /**
     * 技术领域
     */
    private BigInteger techDomain;

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

    public BigInteger getTechDomain() {
        return techDomain;
    }

    public void setTechDomain(BigInteger techDomain) {
        this.techDomain = techDomain;
    }
}
