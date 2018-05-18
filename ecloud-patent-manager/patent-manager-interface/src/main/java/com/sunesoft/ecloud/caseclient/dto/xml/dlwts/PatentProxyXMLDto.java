package com.sunesoft.ecloud.caseclient.dto.xml.dlwts;

import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 代理委托书信息
 */
@XStreamAlias("专利代理委托书")
public class PatentProxyXMLDto {

    /**
     *被委托专利代理机构名称
     */
    @XStreamAlias("被委托专利代理机构名称")
    private String agencyName;

    /**
     *被委托专利代理机构代码
     */
    @XStreamAlias("被委托专利代理机构代码")
    private String agencyCode;


    /**
     *委托代办发明名称
     */
    @XStreamAlias("委托代办发明名称")
    private String patentName;


    /**
     *委托代办发明专利申请号
     */
    @XStreamAlias("委托代办发明专利申请号")
    private String applicationNo = "";


    /**
     *委托代办新型检索报告发明名称
     */
    @XStreamAlias("委托代办新型检索报告发明名称")
    private String checkNewReportPatentName = "";


    /**
     *委托代办新型检索报告申请号
     */
    @XStreamAlias("委托代办新型检索报告申请号")
    private String checkNewReportApplicationNo = "";


    /**
     *代理人
     */
    @XStreamAlias("代理人")
    private List<ProxyAgent> agentList;


    /**
     *委托人签章列表
     */
    @XStreamAlias("委托人签章列表")
    private List<Entrustor> entrustorSignatureList;


    /**
     *被委托人签章
     */
    @XStreamAlias("被委托人签章")
    private String agentSignature;


    /**
     *委托日期
     */
    @XStreamAlias("委托日期")
    private XMLDate XMLDate;


    /**
     *图片或照片
     */
    @XStreamImplicit
    private List<Picture> pictureList;

    @XStreamAlias("代理委托信息与扫描件信息一致声明")
    private InformationConsistencyStatement informationConsistencyStatement;

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
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

    public String getCheckNewReportPatentName() {
        return checkNewReportPatentName;
    }

    public void setCheckNewReportPatentName(String checkNewReportPatentName) {
        this.checkNewReportPatentName = checkNewReportPatentName;
    }

    public String getCheckNewReportApplicationNo() {
        return checkNewReportApplicationNo;
    }

    public void setCheckNewReportApplicationNo(String checkNewReportApplicationNo) {
        this.checkNewReportApplicationNo = checkNewReportApplicationNo;
    }

    public List<ProxyAgent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<ProxyAgent> agentList) {
        this.agentList = agentList;
    }

    public List<Entrustor> getEntrustorSignatureList() {
        return entrustorSignatureList;
    }

    public void setEntrustorSignatureList(List<Entrustor> entrustorSignatureList) {
        this.entrustorSignatureList = entrustorSignatureList;
    }

    public String getAgentSignature() {
        return agentSignature;
    }

    public void setAgentSignature(String agentSignature) {
        this.agentSignature = agentSignature;
    }

    public XMLDate getXMLDate() {
        return XMLDate;
    }

    public void setXMLDate(XMLDate XMLDate) {
        this.XMLDate = XMLDate;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public InformationConsistencyStatement getInformationConsistencyStatement() {
        return informationConsistencyStatement;
    }

    public void setInformationConsistencyStatement(InformationConsistencyStatement informationConsistencyStatement) {
        this.informationConsistencyStatement = informationConsistencyStatement;
    }
}
