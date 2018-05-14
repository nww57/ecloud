package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.caseclient.enums.PatentFeeType;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 官费详情
 */
@Entity
@Table(name = "pat_fee_info", schema = "springcloud", catalog = "")
public class PatFeeInfo extends IEntity {

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private PatentInfo patentInfo;

    /**
     *状态
     */
    @Column(name = "status")
    private boolean status;

    /**
     *费用类型
     */
    @Column(name = "feeType")
    @Enumerated(EnumType.STRING)
    private PatentFeeType feeType;

    /**
     *金额
     */
    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    /**
     *缴费期限
     */
    @Column(name = "paymentPeriod")
    private LocalDate paymentPeriod;

    /**
     *到账时间
     */
    @Column(name = "paymentDate")
    private LocalDate paymentDate;

    /**
     *核实缴费日期
     */
    @Column(name = "verifyPaymentDate")
    private LocalDate verifyPaymentDate;

    /**
     *收据抬头
     */
    @Column(name = "receiptTitle")
    private String receiptTitle;

    /**
     *附件
     */
    @Column(name = "attachment")
    private String attachment;

    @Column(name = "feeDetail",columnDefinition = "TEXT")
    private String feeDetail;

    public PatFeeInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public PatentInfo getPatentInfo() {
        this.status = false;
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PatentFeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(PatentFeeType feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(LocalDate paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getVerifyPaymentDate() {
        return verifyPaymentDate;
    }

    public void setVerifyPaymentDate(LocalDate verifyPaymentDate) {
        this.verifyPaymentDate = verifyPaymentDate;
    }

    public String getReceiptTitle() {
        return receiptTitle;
    }

    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(String feeDetail) {
        this.feeDetail = feeDetail;
    }
}
