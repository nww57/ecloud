package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caseclient.enums.PatentType;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 专利列表
 */
public class PatentListDto {


    private UUID id;


    /**
     * 申请号
     */
    private String applicationNo;

    /**
     * 案件号
     */
    private String caseNo;

    /**
     *案件名称/专利名称
     */
    private String patentName;

    /**
     * 最近期限日期
     */
    private LocalDate nodeExpiryDate;

    /**
     *专利类型
     */
    private PatentType patentType;

    /**
     *案件状态
     */
    private PatentNode patentNode;

    /**
     *合同号
     */
    private String contractNo;

    /**
     *客户名称
     */
    private String customerName;


    /**
     *申请人
     */
    private String applicants;

    /**
     *发明人
     */
    private String inventors;

    /**
     *代理人
     */
    private String agents;

    /**
     *费减比列
     */
    private Integer feeReduceRate;

    /**
     *申请日
     */
    private LocalDate applicationDate;

    /**
     *授权日
     */
    private LocalDate authorizationDate;

    /**
     * 创建日期
     */
    private LocalDate createDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public LocalDate getNodeExpiryDate() {
        return nodeExpiryDate;
    }

    public void setNodeExpiryDate(LocalDate nodeExpiryDate) {
        this.nodeExpiryDate = nodeExpiryDate;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }

    public PatentNode getPatentNode() {
        return patentNode;
    }

    public void setPatentNode(PatentNode patentNode) {
        this.patentNode = patentNode;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public Integer getFeeReduceRate() {
        return feeReduceRate;
    }

    public void setFeeReduceRate(Integer feeReduceRate) {
        this.feeReduceRate = feeReduceRate;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(LocalDate authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
