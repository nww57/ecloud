package com.sunesoft.ecloud.admin.domain.patent;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/12
 */
@Entity
@Table(name = "patent_info")
public class PatentInfo extends IEntity{

    @ManyToOne
    @JoinColumn(name = "caseId")
    private CaseInfo caseInfo;

    @Column(name = "customerId")
    private UUID customerId;

    @Column(name = "patentNo")
    private String patentNo;

    @Column(name = "patentName")
    private String patentName;

    @Column(name = "patentType")
    private String patentType;

    @Column(name = "reduceRate")
    private BigDecimal reduceRate;

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

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public BigDecimal getReduceRate() {
        return reduceRate;
    }

    public void setReduceRate(BigDecimal reduceRate) {
        this.reduceRate = reduceRate;
    }
}
