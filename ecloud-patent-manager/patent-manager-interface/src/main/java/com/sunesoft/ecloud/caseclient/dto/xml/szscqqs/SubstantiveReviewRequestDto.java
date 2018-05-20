package com.sunesoft.ecloud.caseclient.dto.xml.szscqqs;

import com.sunesoft.ecloud.caseclient.dto.xml.SignatureInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 实质审查请求书
 */
@XStreamAlias("实质审查请求书")
public class SubstantiveReviewRequestDto {

    /**
     * 专利申请 信息
     */
    @XStreamAlias("专利申请")
    private SubstantiveReviewRequestPatentInfo patentInfo;

    /**
     * 请求内容
     */
    @XStreamAlias("请求内容")
    private SubstantiveReviewRequestContentInfo contentInfo;

    /**
     * 附件清单
     */
    @XStreamAlias("附件清单")
    private List<AttachmentInfo> attachmentInfo;

    /**
     *备注
     */
    @XStreamAlias("备注")
    private SubstantiveReviewRequestRemarksInfo remarksInfo;

    /**
     * 申请人代表人或专利代理机构签章
     */
    @XStreamAlias("申请人代表人或专利代理机构签章")
    private SignatureInfo signatureInfo;

    /**
     * 国家知识产权局处理意见
     */
    @XStreamAlias("国家知识产权局处理意见")
    private SubstantiveReviewRequestOpinionInfo opinionInfo;

    public SubstantiveReviewRequestDto() {
        this.attachmentInfo = initAttachmentInfo();
    }

    private List<AttachmentInfo> initAttachmentInfo(){
        List<AttachmentInfo> infoList = new ArrayList<>();
        infoList.add(new AttachmentInfo(1,""));
        return infoList;
    }

    public SubstantiveReviewRequestPatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(SubstantiveReviewRequestPatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public SubstantiveReviewRequestContentInfo getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(SubstantiveReviewRequestContentInfo contentInfo) {
        this.contentInfo = contentInfo;
    }

    public List<AttachmentInfo> getAttachmentInfo() {
        return attachmentInfo;
    }

    public void setAttachmentInfo(List<AttachmentInfo> attachmentInfo) {
        this.attachmentInfo = attachmentInfo;
    }

    public SubstantiveReviewRequestRemarksInfo getRemarksInfo() {
        return remarksInfo;
    }

    public void setRemarksInfo(SubstantiveReviewRequestRemarksInfo remarksInfo) {
        this.remarksInfo = remarksInfo;
    }

    public SignatureInfo getSignatureInfo() {
        return signatureInfo;
    }

    public void setSignatureInfo(SignatureInfo signatureInfo) {
        this.signatureInfo = signatureInfo;
    }

    public SubstantiveReviewRequestOpinionInfo getOpinionInfo() {
        return opinionInfo;
    }

    public void setOpinionInfo(SubstantiveReviewRequestOpinionInfo opinionInfo) {
        this.opinionInfo = opinionInfo;
    }
}
