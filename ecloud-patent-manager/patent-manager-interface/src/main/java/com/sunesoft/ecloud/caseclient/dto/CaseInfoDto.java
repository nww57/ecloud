package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.CaseType;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseInfoDto {

    /**
     * 所属企业id
     */
    private UUID agId;

    private UUID id;

    /**
     * 案件号
     */
    private String caseNo;

    /**
     * 案件名称
     */
    private String caseName;

    /**
     *案件类型
     */
    private CaseType caseType;

    /**
     *客户id
     */
    private UUID customerId;

    /**
     *费减比列
     */
    private BigDecimal feeReduceRate;

    /**
     * todo 委托书
     */

    /**
     * todo 交底资料
     */

    /**
     *备注
     */
    private String comments;

    /**
     * 立案人姓名
     */
    private String caseCreatorName;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCaseCreatorName() {
        return caseCreatorName;
    }

    public void setCaseCreatorName(String caseCreatorName) {
        this.caseCreatorName = caseCreatorName;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }
}
