package com.sunesoft.ecloud.caseclient.dto.xml.szscqqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 专利申请 信息
 */
public class SubstantiveReviewRequestPatentInfo {

    @XStreamAlias("申请号")
    private String applicationNo;
    @XStreamAlias("发明创造名称")
    private String patentName;
    @XStreamAlias("申请人或专利权人姓名或名称")
    private String applicantName;

    public SubstantiveReviewRequestPatentInfo() {
        this.applicationNo = "";
        this.patentName = "";
        this.applicantName = "";
    }

    public SubstantiveReviewRequestPatentInfo(String patentName, String applicantName) {
        this.applicationNo = "";
        this.patentName = patentName;
        this.applicantName = applicantName;
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

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }
}
