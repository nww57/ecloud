package com.sunesoft.ecloud.caseclient.dto.notice;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class NoticeListInfoDto {

    private UUID id;

    /**
     * 案件号
     */
    private String caseNo;

    /**
     * 申请号
     */
    private String applicationNo;

    /**
     * 专利名称
     */
    private String patentName;

    /**
     * 通知书名称
     */
    private String noticeName;

    /**
     * 通知书编码
     */
    private String noticeCode;
    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate applicationDate;

    /**
     * 发文日
     */
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate sendFileDate;

    /**
     * 客户
     */
    private String customerName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getSendFileDate() {
        return sendFileDate;
    }

    public void setSendFileDate(LocalDate sendFileDate) {
        this.sendFileDate = sendFileDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
