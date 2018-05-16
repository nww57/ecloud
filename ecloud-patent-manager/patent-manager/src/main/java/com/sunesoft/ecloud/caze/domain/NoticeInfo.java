package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 未受理通知书
 */
@Entity
@Table(name = "pat_notice_info")
public class NoticeInfo extends BizEntity {


    /**
     * 案件号
     */
    @Column(name = "caseNo")
    private String caseNo;

    /**
     * 通知书处理状态
     */
    @Column(name = "handelStatus")
    private boolean handleStatus;

    /**
     * 申请号
     */
    @Column(name = "applicationNo")
    private String applicationNo;

    /**
     * 专利名称
     */
    @Column(name = "patentName")
    private String patentName;

    /**
     * 通知书名称
     */
    @Column(name = "noticeName")
    private String noticeName;

    /**
     * 通知书编码
     */
    @Column(name = "noticeCode")
    private String noticeCode;


    /**
     * 申请日
     */
    @Column(name = "applicationDate")
    private LocalDate applicationDate;

    /**
     * 发文日
     */
    @Column(name = "sendFileDate")
    private LocalDate sendFileDate;

    /**
     * 发文序列号
     */
    @Column(name = "fileSerializeNo")
    private String fileSerializeNo;

    /**
     * 通知书内容
     */
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "fileName")
    private String fileName;

    public NoticeInfo() {
        this.handleStatus = false;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(boolean handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getFileSerializeNo() {
        return fileSerializeNo;
    }

    public void setFileSerializeNo(String fileSerializeNo) {
        this.fileSerializeNo = fileSerializeNo;
    }
}
