package com.sunesoft.ecloud.caseclient.criterias;

import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.common.cretiria.TCretiria;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseInfoQueryCriteria extends TCretiria {

    /**
     *案件编号
     */
    private String caseNo;

    /**
     *案件名称
     */
    private String caseName;

    /**
     * 专利类型
     */
    private PatentType patentType;

    /**
     *专利号
     */
    private String patentNo;


    /**
     * 客户名称
     */
    private String customerName;

    /**
     *费减比列
     */
    private String feeReduceRate;

    /**
     *立案起始时间
     */
    private String caseCreateDateStart;

    /**
     *立案结束时间
     */
    private String caseCreateDateEnd;

    /**
     * 立案人
     */
    private String caseCreatorName;

    /**
     *业务顾问
     */
    private String consultantName;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCaseCreateDateStart() {
        return caseCreateDateStart;
    }

    public void setCaseCreateDateStart(String caseCreateDateStart) {
        this.caseCreateDateStart = caseCreateDateStart;
    }

    public String getCaseCreateDateEnd() {
        return caseCreateDateEnd;
    }

    public void setCaseCreateDateEnd(String caseCreateDateEnd) {
        this.caseCreateDateEnd = caseCreateDateEnd;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getCaseCreatorName() {
        return caseCreatorName;
    }

    public void setCaseCreatorName(String caseCreatorName) {
        this.caseCreatorName = caseCreatorName;
    }

    public String getFeeReduceRate() {
        return feeReduceRate;
    }

    public void setFeeReduceRate(String feeReduceRate) {
        this.feeReduceRate = feeReduceRate;
    }

    public String getPatentNo() {
        return patentNo;
    }

    public void setPatentNo(String patentNo) {
        this.patentNo = patentNo;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }
}
