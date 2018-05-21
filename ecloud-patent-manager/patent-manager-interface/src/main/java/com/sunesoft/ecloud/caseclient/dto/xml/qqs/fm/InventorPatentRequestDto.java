package com.sunesoft.ecloud.caseclient.dto.xml.qqs.fm;

import com.sunesoft.ecloud.caseclient.dto.xml.ApprovalOpinion;
import com.sunesoft.ecloud.caseclient.dto.xml.SignatureInfo;
import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.sunesoft.ecloud.caseclient.dto.xml.qqs.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;

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
    private PublishAdvance publishAdvance;

    @XStreamAlias("遗传资源")
    private GeneticResources geneticResources;

    @XStreamAlias("同日申请")
    private ApplySameDay applySameDay;

    @XStreamAlias("摘要附图")
    private AbstractPicture abstractPicture;

    @XStreamAlias("申请文件清单")
    private ApplyFileInfo applyFileInfo;

    @XStreamAlias("附加文件清单")
    private List<AttachFile> attachBasicFileInfoList;

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
        this.sampleList = initBiomaterialSample();
        this.priorItemList = initPriorItem();
        this.noveltyStatement = new NoveltyStatement();
        this.applyFileInfo = initApplyFileInfo();
        this.attachBasicFileInfoList = initAttachFileInfo();
        this.publishAdvance = new PublishAdvance(true);
        this.applySameDay = new ApplySameDay(false);
        this.geneticResources = new GeneticResources(false);
        this.abstractPicture = new AbstractPicture("");
        this.approvalOpinion = new ApprovalOpinion("",new XMLDate());
    }



    /**
     * 初始化 生物材料样品信息
     * @return
     */
    private List<BiomaterialSample> initBiomaterialSample(){
        List<BiomaterialSample> sampleList = new ArrayList<>();
        sampleList.add(new BiomaterialSample(1,"","",new XMLDate(),"","",new Survival()));
        return sampleList;
    }

    /**
     * 初始化优先权项
     * @return
     */
    private List<PriorItem> initPriorItem() {
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
    private ApplyFileInfo initApplyFileInfo(){
        ApplyFileInfo info = new ApplyFileInfo(9,ApplyFileInfo.generateApplyFileInfo());
        return info;
    }

    /**
     * 初始化附加文件信息
     * @return
     */
    private List<AttachFile> initAttachFileInfo() {
        List<AttachFile> basicFileInfoList = new ArrayList<>();
        basicFileInfoList.add(new AttachFile(1,"专利代理委托书","100007",0));
        return basicFileInfoList;
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

    public PublishAdvance getPublishAdvance() {
        return publishAdvance;
    }

    public void setPublishAdvance(PublishAdvance publishAdvance) {
        this.publishAdvance = publishAdvance;
    }

    public GeneticResources getGeneticResources() {
        return geneticResources;
    }

    public void setGeneticResources(GeneticResources geneticResources) {
        this.geneticResources = geneticResources;
    }

    public ApplySameDay getApplySameDay() {
        return applySameDay;
    }

    public void setApplySameDay(ApplySameDay applySameDay) {
        this.applySameDay = applySameDay;
    }

    public AbstractPicture getAbstractPicture() {
        return abstractPicture;
    }

    public void setAbstractPicture(AbstractPicture abstractPicture) {
        this.abstractPicture = abstractPicture;
    }

    public ApplyFileInfo getApplyFileInfo() {
        return applyFileInfo;
    }

    public void setApplyFileInfo(ApplyFileInfo applyFileInfo) {
        this.applyFileInfo = applyFileInfo;
    }

    public List<AttachFile> getAttachBasicFileInfoList() {
        return attachBasicFileInfoList;
    }

    public void setAttachBasicFileInfoList(List<AttachFile> attachBasicFileInfoList) {
        this.attachBasicFileInfoList = attachBasicFileInfoList;
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
