package com.sunesoft.ecloud.caseclient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author: niww
 * @Date: 2018/4/15
 */
public class CasePatentInfoDto extends CaseInfoDto{
    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户负责人
     */
    private String customerLeader;

    /**
     * 负责人手机
     */
    private String customerLeaderMobile;

    /**
     * 业务顾问
     */
    private String customerConsultantName;


    /**
     * 立案时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime caseCreateDate;


    private String patentId;

    /**
     * 专利名称
     */
    private String patentName;

    /**
     * 专利号
     */
    private String patentNo;

    /**
     * 专利类型
     */
    private String patentType;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLeader() {
        return customerLeader;
    }

    public void setCustomerLeader(String customerLeader) {
        this.customerLeader = customerLeader;
    }

    public String getCustomerLeaderMobile() {
        return customerLeaderMobile;
    }

    public void setCustomerLeaderMobile(String customerLeaderMobile) {
        this.customerLeaderMobile = customerLeaderMobile;
    }

    public String getCustomerConsultantName() {
        return customerConsultantName;
    }

    public void setCustomerConsultantName(String customerConsultantName) {
        this.customerConsultantName = customerConsultantName;
    }



    public LocalDateTime getCaseCreateDate() {
        return caseCreateDate;
    }

    public void setCaseCreateDate(LocalDateTime caseCreateDate) {
        this.caseCreateDate = caseCreateDate;
    }

    public String getPatentId() {
        return patentId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentNo() {
        return patentNo;
    }

    public void setPatentNo(String patentNo) {
        this.patentNo = patentNo;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }
}
