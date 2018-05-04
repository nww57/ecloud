package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 客户要求
 */
@Entity
@Table(name = "pat_customer_damand", schema = "springcloud", catalog = "")
public class PatCustomerDemand extends IEntity {

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private PatentInfo patentInfo;

    /**
     *同时提实审
     */
    @Column(name="isRealTrial")
    private boolean isRealTrial;

    /**
     *提前公布
     */
    @Column(name="isAdvancePublicity")
    private boolean isAdvancePublicity;

    /**
     *请求费用减缓
     */
    @Column(name="isFeeReduce")
    private boolean isFeeReduce;

    /**
     *优先权项
     */
    @Column(name="isReqPriority")
    private boolean isReqPriority;

    public PatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
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
