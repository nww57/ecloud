package com.sunesoft.ecloud.admin.domain.patent;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/12
 */
@Entity
@Table(name = "case_info")
public class CaseInfo extends IEntity {

    /**
     * 案件编号
     */
    @Column(name = "caseNo")
    private String caseNo;
    /**
     *案件名称
     */
    @Column(name = "caseName")
    private String caseName;
    /**
     *案件类型
     */
    @Column(name = "caseType")
    private CaseType caseType;
    /**
     *客户id
     */
    @Column(name = "customerId")
    private UUID customerId;
    /**
     *费减比列
     */
    @Column(name = "recordRate")
    private BigDecimal recordRate;
    /**
     *备注
     */
    @Column(name = "comments")
    private String comments;

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getRecordRate() {
        return recordRate;
    }

    public void setRecordRate(BigDecimal recordRate) {
        this.recordRate = recordRate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
