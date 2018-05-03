package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.TechnologyEnum;

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
    private UUID engineerMasterId;

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

    public UUID getEngineerMasterId() {
        return engineerMasterId;
    }

    public void setEngineerMasterId(UUID engineerMasterId) {
        this.engineerMasterId = engineerMasterId;
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
}
