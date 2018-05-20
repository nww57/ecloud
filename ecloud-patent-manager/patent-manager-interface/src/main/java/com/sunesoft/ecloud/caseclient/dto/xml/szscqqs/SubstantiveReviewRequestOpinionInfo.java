package com.sunesoft.ecloud.caseclient.dto.xml.szscqqs;

import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlAccessOrder;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class SubstantiveReviewRequestOpinionInfo {

    @XStreamAlias("意见内容")
    private String opinion;
    @XStreamAlias("提出日期")
    private XMLDate date;

    public SubstantiveReviewRequestOpinionInfo() {
        this.opinion = "";
        this.date = new XMLDate();
    }

    public SubstantiveReviewRequestOpinionInfo(String opinion, XMLDate date) {
        this.opinion = opinion;
        this.date = date;
    }

}
