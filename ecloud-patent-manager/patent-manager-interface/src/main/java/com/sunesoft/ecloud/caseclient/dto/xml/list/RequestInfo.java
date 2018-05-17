package com.sunesoft.ecloud.caseclient.dto.xml.list;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 * 请求信息
 */
public class RequestInfo {

    /**
     * 电子申请案件id
     */
    @XStreamAlias("DIANZISQAJID")
    private String id;

    /**
     * 申请方式 离线0  在线1
     */
    @XStreamAlias("SHENQINGFS")
    private int applyMode;


    /**
     * 业务类型
     * 0 普通申请 发明
     * 1 普通申请 新型
     * 2 普通申请 外观
     * 3 pct申请 发明
     * 4 pct申请 新型
     * 5 复审
     * 6 无效
     */
    @XStreamAlias("YEWULX")
    private int businessType;


    /**
     * 文件类型 新申请0 中间文件1
     */
    @XStreamAlias("WENJIANLX")
    private int fileType;

    /**
     * 提交人代码
     */
    @XStreamAlias("TIJIAORDM")
    private String submiterCode;

    /**
     * 发明名称
     */
    @XStreamAlias("FAMINGMC")
    private String patentName;

    /**
     * 申请号
     */
    @XStreamAlias("SHENQINGH")
    private String applicationNo;

    /**
     * 委内编号
     */
    @XStreamAlias("WEINEIBH")
    private String commissionNo;

    /**
     * 国际申请号
     */
    @XStreamAlias("GUOJISQH")
    private String internationalApplicationNo;

    /**
     * 内部编号
     */
    @XStreamAlias("NEIBUBH")
    private String caseNo;


    /**
     * 包id
     */
    @XStreamAlias("BAOID")
    private String baoId;

    public RequestInfo() {
        this.applicationNo = "";
        this.commissionNo = "";
        this.internationalApplicationNo = "";
        this.baoId = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getApplyMode() {
        return applyMode;
    }

    public void setApplyMode(int applyMode) {
        this.applyMode = applyMode;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getSubmiterCode() {
        return submiterCode;
    }

    public void setSubmiterCode(String submiterCode) {
        this.submiterCode = submiterCode;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getCommissionNo() {
        return commissionNo;
    }

    public void setCommissionNo(String commissionNo) {
        this.commissionNo = commissionNo;
    }

    public String getInternationalApplicationNo() {
        return internationalApplicationNo;
    }

    public void setInternationalApplicationNo(String internationalApplicationNo) {
        this.internationalApplicationNo = internationalApplicationNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getBaoId() {
        return baoId;
    }

    public void setBaoId(String baoId) {
        this.baoId = baoId;
    }
}
