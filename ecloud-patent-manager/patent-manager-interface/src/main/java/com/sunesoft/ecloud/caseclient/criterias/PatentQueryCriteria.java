package com.sunesoft.ecloud.caseclient.criterias;

import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caseclient.enums.PatentType;
import com.sunesoft.ecloud.common.cretiria.TCretiria;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 * 专利列表查询参数
 */
public class PatentQueryCriteria extends TCretiria {

    private UUID agId;

    /**
     * 用户id（为了获取查询配置）
     */
    private UUID userId;

    /**
     *申请号
     */
    private String applicationNo;

    /**
     *案件号
     */
    private String caseNo;

    /**
     *案件名称/专利名称
     */
    private String patentName;

    /**
     *最近期限日期
     */
    private String nodeExpiryDateStart;

    /**
     *最近期限日期
     */
    private String nodeExpiryDateEnd;

    /**
     *专利类型
     */
    private PatentType patentType;

    /**
     *案件节点/专利节点
     */
    private PatentNode patentNode;

    /**
     *所属合同
     */
    private String contractNo;

    /**
     *客户
     */
    private String customerName;

    /**
     *案源人
     */
    private String introducorName;

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
     *申请日
     */
    private String applicationDateStart;

    /**
     *申请日
     */
    private String applicationDateEnd;

    /**
     *授权日
     */
    private String authorizationDateStart;

    /**
     *授权日
     */
    private String authorizationDateEnd;

    /**
     *是否延迟
     */
    private Boolean isDelayed;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
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

    public String getNodeExpiryDateStart() {
        return nodeExpiryDateStart;
    }

    public void setNodeExpiryDateStart(String nodeExpiryDateStart) {
        this.nodeExpiryDateStart = nodeExpiryDateStart;
    }

    public String getNodeExpiryDateEnd() {
        return nodeExpiryDateEnd;
    }

    public void setNodeExpiryDateEnd(String nodeExpiryDateEnd) {
        this.nodeExpiryDateEnd = nodeExpiryDateEnd;
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

    public String getIntroducorName() {
        return introducorName;
    }

    public void setIntroducorName(String introducorName) {
        this.introducorName = introducorName;
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

    public String getApplicationDateStart() {
        return applicationDateStart;
    }

    public void setApplicationDateStart(String applicationDateStart) {
        this.applicationDateStart = applicationDateStart;
    }

    public String getApplicationDateEnd() {
        return applicationDateEnd;
    }

    public void setApplicationDateEnd(String applicationDateEnd) {
        this.applicationDateEnd = applicationDateEnd;
    }

    public String getAuthorizationDateStart() {
        return authorizationDateStart;
    }

    public void setAuthorizationDateStart(String authorizationDateStart) {
        this.authorizationDateStart = authorizationDateStart;
    }

    public String getAuthorizationDateEnd() {
        return authorizationDateEnd;
    }

    public void setAuthorizationDateEnd(String authorizationDateEnd) {
        this.authorizationDateEnd = authorizationDateEnd;
    }

    public Boolean getIsDelayed() {
        return isDelayed;
    }

    public void setIsDelayed(Boolean delayed) {
        isDelayed = delayed;
    }
}
