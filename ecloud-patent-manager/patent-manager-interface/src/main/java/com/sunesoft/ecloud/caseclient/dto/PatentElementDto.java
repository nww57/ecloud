package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentNode;

import java.time.LocalDate;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 * 专利著录项
 */
public class PatentElementDto {

    /**
     * 申请号/专利号
     */
    private String applicationNo;

    /**
     *专利名称
     */
    private String patentName;

    /**
     *申请日
     */
    private LocalDate applicationDate;

    /**
     *主分类号
     */
    private String mainClassificationNumber;

    /**
     *案件节点
     */
    private PatentNode patentNode;

    /**
     *分案提交日
     */
    private LocalDate applicationSubmissionDate;

    /**
     *申请人
     */
    private String applicants;

    /**
     *发明人
     */
    private String inventors;

    /**
     *代理机构
     */
    private String agency;

    /**
     *代理人
     */
    private String agencyAgents;

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setApplicationSubmissionDate(LocalDate applicationSubmissionDate) {
        this.applicationSubmissionDate = applicationSubmissionDate;
    }

    public String getMainClassificationNumber() {
        return mainClassificationNumber;
    }

    public void setMainClassificationNumber(String mainClassificationNumber) {
        this.mainClassificationNumber = mainClassificationNumber;
    }

    public PatentNode getPatentNode() {
        return patentNode;
    }

    public void setPatentNode(PatentNode patentNode) {
        this.patentNode = patentNode;
    }

    public LocalDate getApplicationSubmissionDate() {
        return applicationSubmissionDate;
    }

    public String getApplicants() {
        return applicants;
    }

    public void setApplicants(String applicants) {
        this.applicants = applicants;
    }

    public String getInventors() {
        return inventors;
    }

    public void setInventors(String inventors) {
        this.inventors = inventors;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgencyAgents() {
        return agencyAgents;
    }

    public void setAgencyAgents(String agencyAgents) {
        this.agencyAgents = agencyAgents;
    }
}
