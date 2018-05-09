package com.sunesoft.ecloud.caseclient.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Auther: niww
 * @Date: 2018/5/9/009
 * 添加官费信息
 */
public class AddPatentOfficialFeeDto {

    /**
     *案件号
     */
    private String caseNo;

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

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
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
}
