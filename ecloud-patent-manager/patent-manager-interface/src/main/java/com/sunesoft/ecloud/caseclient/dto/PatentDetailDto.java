package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.caseclient.enums.TechnologyEnum;

import java.util.List;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 */
public class PatentDetailDto {


    private UUID id;

    /**
     *专利类型
     */
    private PatentType patentType;

    /**
     *案件号/内部编号
     */
    private String caseNo;

    /**
     *客户名称
     */
    private String customerName;

    /**
     *安源人名称
     */
    private String salesmanName;

    /**
     *专利名称/案件名称
     */
    private String patentName;

    /**
     * 工程师组长
     */
    private String engineerLeaderName;


    /**
     *技术领域
     */
    private TechnologyEnum techDomain;

    //客户要求

    /**
     *同时提实审
     */
    private boolean isRealTrial;

    /**
     *提前公布
     */
    private boolean isAdvancePublicity;

    /**
     *请求费用减缓
     */
    private boolean isFeeReduce;

    /**
     *优先权项
     */
    private boolean isReqPriority;

    /**
     * 申请人列表
     */
    private List<PatApplicantDto> applicantList;

    /**
     * 发明人列表
     */
    private List<PatInventorDto> inventorList;


    /**
     * 代理人列表
     */
    private List<PatAgentDto> agentList;


    /**
     * 优先权项里诶包
     */
    private List<PatPriorityClaimsDto> priorityClaimsList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public TechnologyEnum getTechDomain() {
        return techDomain;
    }

    public void setTechDomain(TechnologyEnum techDomain) {
        this.techDomain = techDomain;
    }

    public boolean isRealTrial() {
        return isRealTrial;
    }

    public void setRealTrial(boolean realTrial) {
        isRealTrial = realTrial;
    }

    public boolean isAdvancePublicity() {
        return isAdvancePublicity;
    }

    public void setAdvancePublicity(boolean advancePublicity) {
        isAdvancePublicity = advancePublicity;
    }

    public boolean isFeeReduce() {
        return isFeeReduce;
    }

    public void setFeeReduce(boolean feeReduce) {
        isFeeReduce = feeReduce;
    }

    public boolean isReqPriority() {
        return isReqPriority;
    }

    public void setReqPriority(boolean reqPriority) {
        isReqPriority = reqPriority;
    }

    public List<PatApplicantDto> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<PatApplicantDto> applicantList) {
        this.applicantList = applicantList;
    }

    public List<PatInventorDto> getInventorList() {
        return inventorList;
    }

    public void setInventorList(List<PatInventorDto> inventorList) {
        this.inventorList = inventorList;
    }

    public List<PatAgentDto> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<PatAgentDto> agentList) {
        this.agentList = agentList;
    }

    public List<PatPriorityClaimsDto> getPriorityClaimsList() {
        return priorityClaimsList;
    }

    public void setPriorityClaimsList(List<PatPriorityClaimsDto> priorityClaimsList) {
        this.priorityClaimsList = priorityClaimsList;
    }

    public String getEngineerLeaderName() {
        return engineerLeaderName;
    }

    public void setEngineerLeaderName(String engineerLeaderName) {
        this.engineerLeaderName = engineerLeaderName;
    }
}
