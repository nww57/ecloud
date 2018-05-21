package com.sunesoft.ecloud.caseclient.dto.xml.qqs.wg;

import com.sunesoft.ecloud.caseclient.dto.xml.ApprovalOpinion;
import com.sunesoft.ecloud.caseclient.dto.xml.SignatureInfo;
import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.sunesoft.ecloud.caseclient.dto.xml.qqs.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
@XStreamAlias("外观设计专利请求书")
public class AppearancePatentRequestDto {

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

    @XStreamAlias("挂号号码")
    private String registrationNumber;

    @XStreamAlias("发明名称")
    private String patentName;

    @XStreamAlias("发明英文名称")
    private String patentNameEn;

    @XStreamAlias("内部编号")
    private String caseNo;

    //基础信息 end

    @XStreamAlias("设计人")
    private Designer designer;

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

    @XStreamAlias("要求优先权声明")
    private List<PriorItem> priorItemList;

    @XStreamAlias("不丧失新颖性申明颖性申明")
    private NoveltyStatement noveltyStatement;

    @XStreamAlias("相似设计")
    private SimilarDesign similarDesign;

    @XStreamAlias("成套产品")
    private CompleteProduct completeProduct;

    @XStreamAlias("申请文件清单")
    private ApplyFileInfo applyFileInfo;

    @XStreamAlias("附加文件清单")
    private AppearanceAttachFileInfo attachFileInfo;

    @XStreamAlias("申请人或代理机构签章")
    private SignatureInfo signatureInfo;

    @XStreamAlias("专利局审批")
    private ApprovalOpinion approvalOpinion;

    public AppearancePatentRequestDto() {
        this.receiveDate = "";
        this.applicationNo = "";
        this.applicationSubmissionDate = "";
        this.applicationDate = "";
        this.feeReduceApprove = "";
        this.registrationNumber = "";
        this.patentNameEn = "";
        this.representer = "";
        this.similarDesign = new SimilarDesign(false,"0");
        this.completeProduct = new CompleteProduct(false,"0");
        this.priorItemList = initPriorItem();
        this.noveltyStatement = new NoveltyStatement();
        this.applyFileInfo = initAppearanceFileInfo();
        this.attachFileInfo = initAttachFileInfo();
        this.approvalOpinion = new ApprovalOpinion("",new XMLDate());
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
    private ApplyFileInfo initAppearanceFileInfo(){
        ApplyFileInfo info = new ApplyFileInfo(7,ApplyFileInfo.generateAppearanceFileInfo());
        return info;
    }

    private AppearanceAttachFileInfo initAttachFileInfo(){
        List<AttachFile> basicFileInfoList = new ArrayList<>();
        basicFileInfoList.add(new AttachFile(1,"专利代理委托书","100007",2));
        AppearanceAttachFileInfo info = new AppearanceAttachFileInfo(basicFileInfoList);
        return info;
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

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getRepresenter() {
        return representer;
    }

    public void setRepresenter(String representer) {
        this.representer = representer;
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

    public SimilarDesign getSimilarDesign() {
        return similarDesign;
    }

    public void setSimilarDesign(SimilarDesign similarDesign) {
        this.similarDesign = similarDesign;
    }

    public CompleteProduct getCompleteProduct() {
        return completeProduct;
    }

    public void setCompleteProduct(CompleteProduct completeProduct) {
        this.completeProduct = completeProduct;
    }

    public ApplyFileInfo getApplyFileInfo() {
        return applyFileInfo;
    }

    public void setApplyFileInfo(ApplyFileInfo applyFileInfo) {
        this.applyFileInfo = applyFileInfo;
    }

    public AppearanceAttachFileInfo getAttachFileInfo() {
        return attachFileInfo;
    }

    public void setAttachFileInfo(AppearanceAttachFileInfo attachFileInfo) {
        this.attachFileInfo = attachFileInfo;
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
