package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.dto.notice.FeeInfoDetailDto;
import com.sunesoft.ecloud.caseclient.enums.PatentFeeType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/5/9/009
 * 添加官费信息
 */
public class AddPatentFeeDto {

    /**
     *申请号/专利号
     */
    private String applicationNo;

    /**
     *费用类型
     */
    private PatentFeeType feeType;

    /**
     *金额
     */
    private BigDecimal totalPrice;

    /**
     *缴费期限
     */
    private LocalDate paymentPeriod;

    /**
     * 费用明细
     */
    private List<FeeInfoDetailDto> feeDetailList;

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
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

    public List<FeeInfoDetailDto> getFeeDetailList() {
        return feeDetailList;
    }

    public void setFeeDetailList(List<FeeInfoDetailDto> feeDetailList) {
        this.feeDetailList = feeDetailList;
    }

    public LocalDate getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(LocalDate paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }


}
