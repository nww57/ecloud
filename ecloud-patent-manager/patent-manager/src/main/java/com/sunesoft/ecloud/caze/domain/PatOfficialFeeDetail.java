package com.sunesoft.ecloud.caze.domain;

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
@Table(name = "pat_officalfeedetail", schema = "springcloud", catalog = "")
public class PatOfficialFeeDetail extends IEntity {

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
    private String status;

    /**
     *费用类型
     */
    @Column(name = "feeType")
    private String feeType;

    /**
     *金额
     */
    @Column(name = "price")
    private BigDecimal price;

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

    public PatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
}
