package com.sunesoft.ecloud.caseclient.dto;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/15/015
 * 专利费用信息处理Dto
 */
public class HandlePatentFeeDto {

    /**
     * 费用记录id
     */
    private UUID feeId;

    /**
     * 抬头
     */
    private String receiptTitle;


    /**
     * 缴费日期
     */
    private LocalDate paymentDate;

    /**
     * 文件id
     */
    private String attachment;

    public UUID getFeeId() {
        return feeId;
    }

    public void setFeeId(UUID feeId) {
        this.feeId = feeId;
    }

    public String getReceiptTitle() {
        return receiptTitle;
    }

    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
