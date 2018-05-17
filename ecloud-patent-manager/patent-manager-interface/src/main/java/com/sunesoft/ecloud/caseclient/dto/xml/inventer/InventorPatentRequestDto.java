package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.ApprovalOpinion;
import com.sunesoft.ecloud.caseclient.dto.xml.SignatureInfo;
import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamAlias("发明专利请求书")
public class InventorPatentRequestDto {

    //基础信息 start
    @XStreamAlias("收到日期")
    private String receiveDate;

    @XStreamAlias("申请号")
    private String applicationNo;

    @XStreamAlias("分案提交日")
    private String applicationSubmissionDate;

    @XStreamAlias("申请日")
    private String applicationDate;

    @XStreamAlias("费减审批")
    private String feeReduceApprove;

    @XStreamAlias("向外申请审批")
    private String outwardApplicationApprove;

    @XStreamAlias("挂号号码")
    private String registrationNumber;

    @XStreamAlias("发明名称")
    private String patentName;

    @XStreamAlias("发明英文名称")
    private String patentNameEn;

    @XStreamAlias("内部编号")
    private String caseNo;

    //基础信息 end

    @XStreamAlias("发明人")
    private Inventor inventor;

    @XStreamAlias("申请人")
    private Applicant applicant;

    @XStreamAlias("代表人")
    private String representer;

    @XStreamAlias("联系人")
    private Contactor contactor;

    @XStreamAlias("专利代理机构")
    private Agency agency;

    @XStreamAlias("分案申请")
    private DivisionApplication divisionApplication;

    @XStreamAlias("生物材料样品信息")
    private List<BiomaterialSample> sampleList;

    @XStreamAlias("序列表")
    private SequenceTable sequenceTable;

    @XStreamAlias("要求优先权声明")
    private List<PriorItem> priorItemList;

    @XStreamAlias("不丧失新颖性申明颖性申明")
    private NoveltyStatement noveltyStatement;

    @XStreamAlias("提前公开")
    private int publishAdvance;

    @XStreamAlias("遗传资源")
    private int geneticResources;

    @XStreamAlias("同日申请")
    private int applySameDay;

    @XStreamAlias("摘要附图")
    private int abstractPicture;

    @XStreamAlias("申请文件清单")
    private ApplyFileInfo applyFileInfo;

    @XStreamImplicit(keyFieldName = "附加文件清单",itemFieldName = "附加文件")
    private List<FileInfo> attachFileInfoList;

    @XStreamAlias("申请人或代理机构签章")
    private SignatureInfo signatureInfo;

    @XStreamAlias("专利局审批")
    private ApprovalOpinion approvalOpinion;

    public InventorPatentRequestDto() {
        this.receiveDate = "";
        this.applicationNo = "";
        this.applicationSubmissionDate = "";
        this.applicationDate = "";
        this.feeReduceApprove = "";
        this.outwardApplicationApprove = "";
        this.registrationNumber = "";
        this.patentNameEn = "";
        this.representer = "";
        this.sampleList = initializationBiomaterialSample();
        this.priorItemList = initializationPriorItem();
        this.noveltyStatement = new NoveltyStatement();
        this.applyFileInfo = initializationApplyFileInfo();
        this.attachFileInfoList = initializationAttachFileInfo();
    }



    /**
     * 初始化 生物材料样品信息
     * @return
     */
    private List<BiomaterialSample> initializationBiomaterialSample(){
        List<BiomaterialSample> sampleList = new ArrayList<>();
        sampleList.add(new BiomaterialSample(1,"","",new XMLDate(),"","",new BiomaterialSample(). new Survival(false)));
        return sampleList;
    }

    /**
     * 初始化优先权项
     * @return
     */
    private List<PriorItem> initializationPriorItem() {
        List<PriorItem> itemList =  new ArrayList<>();
        for(int i = 1;i<9;i++){
            itemList.add(new PriorItem(i));
        }
        return itemList;
    }

    /**
     * 初始化申请文件信息
     * @return
     */
    private ApplyFileInfo initializationApplyFileInfo(){
        ApplyFileInfo info = new ApplyFileInfo(9,ApplyFileInfo.generateApplyFileInfo());
        return info;
    }

    /**
     * 初始化附加文件信息
     * @return
     */
    private List<FileInfo> initializationAttachFileInfo() {
        List<FileInfo> fileInfoList = new ArrayList<>();
        fileInfoList.add(new FileInfo(1,"实质审查请求书","110401",1));
        fileInfoList.add(new FileInfo(2,"专利代理委托书","100007",2));
        return fileInfoList;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public Inventor getInventor() {
        return inventor;
    }

    public void setInventor(Inventor inventor) {
        this.inventor = inventor;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Contactor getContactor() {
        return contactor;
    }

    public void setContactor(Contactor contactor) {
        this.contactor = contactor;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public DivisionApplication getDivisionApplication() {
        return divisionApplication;
    }

    public void setDivisionApplication(DivisionApplication divisionApplication) {
        this.divisionApplication = divisionApplication;
    }

    public List<BiomaterialSample> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<BiomaterialSample> sampleList) {
        this.sampleList = sampleList;
    }

    public SequenceTable getSequenceTable() {
        return sequenceTable;
    }

    public void setSequenceTable(SequenceTable sequenceTable) {
        this.sequenceTable = sequenceTable;
    }

    public List<PriorItem> getPriorItemList() {
        return priorItemList;
    }

    public void setPriorItemList(List<PriorItem> priorItemList) {
        this.priorItemList = priorItemList;
    }

    public NoveltyStatement getNoveltyStatement() {
        return noveltyStatement;
    }

    public void setNoveltyStatement(NoveltyStatement noveltyStatement) {
        this.noveltyStatement = noveltyStatement;
    }

    public int getPublishAdvance() {
        return publishAdvance;
    }

    public void setPublishAdvance(int publishAdvance) {
        this.publishAdvance = publishAdvance;
    }

    public int getGeneticResources() {
        return geneticResources;
    }

    public void setGeneticResources(int geneticResources) {
        this.geneticResources = geneticResources;
    }

    public int getApplySameDay() {
        return applySameDay;
    }

    public void setApplySameDay(int applySameDay) {
        this.applySameDay = applySameDay;
    }

    public int getAbstractPicture() {
        return abstractPicture;
    }

    public void setAbstractPicture(int abstractPicture) {
        this.abstractPicture = abstractPicture;
    }

    public ApplyFileInfo getApplyFileInfo() {
        return applyFileInfo;
    }

    public void setApplyFileInfo(ApplyFileInfo applyFileInfo) {
        this.applyFileInfo = applyFileInfo;
    }

    public List<FileInfo> getAttachFileInfoList() {
        return attachFileInfoList;
    }

    public void setAttachFileInfoList(List<FileInfo> attachFileInfoList) {
        this.attachFileInfoList = attachFileInfoList;
    }

    public SignatureInfo getSignatureInfo() {
        return signatureInfo;
    }

    public void setSignatureInfo(SignatureInfo signatureInfo) {
        this.signatureInfo = signatureInfo;
    }

    public ApprovalOpinion getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(ApprovalOpinion approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }
}
