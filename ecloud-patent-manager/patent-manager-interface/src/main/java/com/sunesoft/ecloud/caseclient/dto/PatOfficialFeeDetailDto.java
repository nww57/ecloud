package com.sunesoft.ecloud.caseclient.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
public class PatOfficialFeeDetailDto {
    /**
     *状态
     */
    private String status;

    /**
     *费用类型
     */
    private String feeType;

    /**
     *金额
     */
    private BigDecimal price;

    /**
     *缴费期限
     */
    private LocalDate paymentPeriod;

    /**
     *到账时间
     */
    private LocalDate paymentDate;

    /**
     *核实缴费日期
     */
    private LocalDate verifyPaymentDate;

    /**
     *收据抬头
     */
    private String receiptTitle;

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
}
