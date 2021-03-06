package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentNode;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 * 专利著录项
 */
public class PatentElementDto {

    private UUID patentId;

    /**
     * 案件号
     */
    private String caseNo;

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
     * 公开日
     */
    private LocalDate publishDate;

    /**
     * 公开号
     */
    private String publishNo;

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

    public UUID getPatentId() {
        return patentId;
    }

    public void setPatentId(UUID patentId) {
        this.patentId = patentId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

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

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishNo() {
        return publishNo;
    }

    public void setPublishNo(String publishNo) {
        this.publishNo = publishNo;
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
