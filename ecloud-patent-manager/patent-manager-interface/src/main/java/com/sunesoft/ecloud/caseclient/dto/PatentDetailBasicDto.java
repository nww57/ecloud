package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.adminclient.TechnologyEnum;
import com.sunesoft.ecloud.caseclient.enums.PatentType;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/9/009
 */
public class PatentDetailBasicDto {

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
     * 客户id
     */
    private UUID customerId;

    /**
     *客户名称
     */
    private String customerName;

    /**
     *案源人姓名
     */
    private String introducerName;

    /**
     *专利名称/案件名称
     */
    private String patentName;

    /**
     * 工程师组长id
     */
    private UUID engineerLeaderId;

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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIntroducerName() {
        return introducerName;
    }

    public void setIntroducerName(String introducerName) {
        this.introducerName = introducerName;
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

    public String getEngineerLeaderName() {
        return engineerLeaderName;
    }

    public void setEngineerLeaderName(String engineerLeaderName) {
        this.engineerLeaderName = engineerLeaderName;
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
