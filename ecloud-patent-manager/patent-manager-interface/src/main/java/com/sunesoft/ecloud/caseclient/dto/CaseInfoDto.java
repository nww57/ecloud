package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.CaseType;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseInfoDto {

    private UUID id;

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
}
