package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.adminclient.TechnologyEnum;

import java.util.List;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/4
 */
public class UpdatePatentDto {

    /**
     * 专利id
     */
    private UUID patentId;

    /**
     * 专利名称
     */
    private String patentName;

    /**
     * 工程师组长
     */
    private UUID engineerLeaderId;

    /**
     *技术领域
     */
    private TechnologyEnum techDomain;

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
     * 专利产品用途
     */
    private String patentProductPurpose;

    /**
     * 设计要点
     */
    private String designMainPoints;

    /**
     *设计要点图片
     */
    private String designMainPointsPicture;

    /**
     * 申请人信息
     */
    private List<UUID> applicantIdList;

    /**
     * 发明人信息
     */
    private List<UUID> inventorIdList;

    /**
     * 代理人信息
     */
    private List<UUID> agentIdList;

    /**
     * 优先权项内容
     */
    private List<PatPriorityClaimsDto> priorityClaimsList;

    public UUID getPatentId() {
        return patentId;
    }

    public void setPatentId(UUID patentId) {
        this.patentId = patentId;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public UUID getEngineerLeaderId() {
        return engineerLeaderId;
    }

    public void setEngineerLeaderId(UUID engineerLeaderId) {
        this.engineerLeaderId = engineerLeaderId;
    }

    public TechnologyEnum getTechDomain() {
        return techDomain;
    }

    public void setTechDomain(TechnologyEnum techDomain) {
        this.techDomain = techDomain;
    }

    public boolean getIsRealTrial() {
        return isRealTrial;
    }

    public void setIsRealTrial(boolean realTrial) {
        isRealTrial = realTrial;
    }

    public boolean getIsAdvancePublicity() {
        return isAdvancePublicity;
    }

    public void setIsAdvancePublicity(boolean advancePublicity) {
        isAdvancePublicity = advancePublicity;
    }

    public boolean getIsFeeReduce() {
        return isFeeReduce;
    }

    public void setIsFeeReduce(boolean feeReduce) {
        isFeeReduce = feeReduce;
    }

    public boolean getIsReqPriority() {
        return isReqPriority;
    }

    public void setIsReqPriority(boolean reqPriority) {
        isReqPriority = reqPriority;
    }

    public List<PatPriorityClaimsDto> getPriorityClaimsList() {
        return priorityClaimsList;
    }

    public void setPriorityClaimsList(List<PatPriorityClaimsDto> priorityClaimsList) {
        this.priorityClaimsList = priorityClaimsList;
    }

    public List<UUID> getApplicantIdList() {
        return applicantIdList;
    }

    public void setApplicantIdList(List<UUID> applicantIdList) {
        this.applicantIdList = applicantIdList;
    }

    public List<UUID> getInventorIdList() {
        return inventorIdList;
    }

    public void setInventorIdList(List<UUID> inventorIdList) {
        this.inventorIdList = inventorIdList;
    }

    public List<UUID> getAgentIdList() {
        return agentIdList;
    }

    public void setAgentIdList(List<UUID> agentIdList) {
        this.agentIdList = agentIdList;
    }

    public String getPatentProductPurpose() {
        return patentProductPurpose;
    }

    public void setPatentProductPurpose(String patentProductPurpose) {
        this.patentProductPurpose = patentProductPurpose;
    }

    public String getDesignMainPoints() {
        return designMainPoints;
    }

    public void setDesignMainPoints(String designMainPoints) {
        this.designMainPoints = designMainPoints;
    }

    public String getDesignMainPointsPicture() {
        return designMainPointsPicture;
    }

    public void setDesignMainPointsPicture(String designMainPointsPicture) {
        this.designMainPointsPicture = designMainPointsPicture;
    }
}
