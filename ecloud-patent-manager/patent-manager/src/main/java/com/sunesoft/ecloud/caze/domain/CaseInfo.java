package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.caseclient.CaseType;
import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/12
 */
@Entity
@Table(name = "case_info")
public class CaseInfo extends BizEntity {


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
    @Enumerated(EnumType.STRING)
    private CaseType caseType;
    /**
     *客户id
     */
    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerId;
    /**
     *费减比列
     */
    @Column(name = "feeReduceRate")
    private BigDecimal feeReduceRate;
    /**
     *备注
     */
    @Column(name = "comments")
    private String comments;



    /**
     * todo 委托书
     */


    /**
     * todo 交底资料
     */

    /**
     * 立案人姓名
     */
    @Column(name = "caseCreatorName")
    private String caseCreatorName;

    public CaseInfo() {

    }

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

    public BigDecimal getFeeReduceRate() {
        return feeReduceRate;
    }

    public void setFeeReduceRate(BigDecimal feeReduceRate) {
        this.feeReduceRate = feeReduceRate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCaseCreatorName() {
        return caseCreatorName;
    }

    public void setCaseCreatorName(String caseCreatorName) {
        this.caseCreatorName = caseCreatorName;
    }

}
