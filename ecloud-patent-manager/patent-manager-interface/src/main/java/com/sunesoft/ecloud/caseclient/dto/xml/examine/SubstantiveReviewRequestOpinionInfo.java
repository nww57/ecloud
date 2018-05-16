package com.sunesoft.ecloud.caseclient.dto.xml.examine;

import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class SubstantiveReviewRequestOpinionInfo {

    @XStreamAlias("意见内容")
    private String opinion;
    @XStreamAlias("提出日期")
    private XMLDate date;

    public SubstantiveReviewRequestOpinionInfo(String opinion, XMLDate date) {
        this.opinion = opinion;
        this.date = date;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public XMLDate getDate() {
        return date;
    }

    public void setDate(XMLDate date) {
        this.date = date;
    }
}
