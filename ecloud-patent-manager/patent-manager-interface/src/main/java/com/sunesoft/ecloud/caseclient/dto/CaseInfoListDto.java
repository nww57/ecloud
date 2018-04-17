package com.sunesoft.ecloud.caseclient.dto;

import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseInfoListDto extends CaseInfoDto{

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户负责人
     */
    private String customerLeader;

    /**
     * 负责人手机
     */
    private String customerLeaderMobile;

    /**
     * 业务顾问
     */
    private String customerConsultantName;

    /**
     * 立案人
     */
    private String caseCreatorName;

    /**
     * 立案时间
     */
    private String caseCreateDate;

    /**
     * 专利信息
     */
    private List<PatentBasicDto> patentBasicList;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLeader() {
        return customerLeader;
    }

    public void setCustomerLeader(String customerLeader) {
        this.customerLeader = customerLeader;
    }

    public String getCustomerLeaderMobile() {
        return customerLeaderMobile;
    }

    public void setCustomerLeaderMobile(String customerLeaderMobile) {
        this.customerLeaderMobile = customerLeaderMobile;
    }

    public String getCustomerConsultantName() {
        return customerConsultantName;
    }

    public void setCustomerConsultantName(String customerConsultantName) {
        this.customerConsultantName = customerConsultantName;
    }

    public String getCaseCreatorName() {
        return caseCreatorName;
    }

    public void setCaseCreatorName(String caseCreatorName) {
        this.caseCreatorName = caseCreatorName;
    }

    public String getCaseCreateDate() {
        return caseCreateDate;
    }

    public void setCaseCreateDate(String caseCreateDate) {
        this.caseCreateDate = caseCreateDate;
    }

    public List<PatentBasicDto> getPatentBasicList() {
        return patentBasicList;
    }

    public void setPatentBasicList(List<PatentBasicDto> patentBasicList) {
        this.patentBasicList = patentBasicList;
    }

}
