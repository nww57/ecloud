package com.sunesoft.ecloud.caseclient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.AliasName;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 未处理受理通知书
 */
public class DismissedNoticeDto {

    private UUID id;

    private UUID agId;

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
     * 申请日
     */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate applicationDate;

    /**
     * 发文日
     */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate sendFileDate;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 其他内容
     */
    private String content;

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

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
