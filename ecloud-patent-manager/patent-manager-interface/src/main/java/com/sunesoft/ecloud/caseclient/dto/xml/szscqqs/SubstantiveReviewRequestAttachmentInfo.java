package com.sunesoft.ecloud.caseclient.dto.xml.szscqqs;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class SubstantiveReviewRequestAttachmentInfo {

    @XStreamImplicit
    private List<AttachmentInfo> attachmentInfoList;

    public List<AttachmentInfo> getAttachmentInfoList() {
        return attachmentInfoList;
    }

    public void setAttachmentInfoList(List<AttachmentInfo> attachmentInfoList) {
        this.attachmentInfoList = attachmentInfoList;
    }
}
