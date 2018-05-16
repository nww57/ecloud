package com.sunesoft.ecloud.caseclient.dto.xml.examine;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
@XStreamConverter(value = AdditionalConverter.class)
public class SubstantiveReviewRequestRemarksInfo {

    @XStreamAlias("该申请为PCT国际申请实审费不予减免")
    private int noReduce;

    @XStreamAlias("该申请为PCT国际申请由EPJPSE作出国际检索报告的实审费减免百分之二十")
    private int reduce20;

    @XStreamAlias("该申请为PCT国际申请由CN作出国际检索报告的实审费减免百分之五十")
    private int reduce50;

    @XStreamAlias("其他情况")
    private int other;

    public SubstantiveReviewRequestRemarksInfo() {
    }

    public SubstantiveReviewRequestRemarksInfo(int noReduce, int reduce20, int reduce50, int other) {
        this.noReduce = noReduce;
        this.reduce20 = reduce20;
        this.reduce50 = reduce50;
        this.other = other;
    }

    public int getNoReduce() {
        return noReduce;
    }

    public void setNoReduce(int noReduce) {
        this.noReduce = noReduce;
    }

    public int getReduce20() {
        return reduce20;
    }

    public void setReduce20(int reduce20) {
        this.reduce20 = reduce20;
    }

    public int getReduce50() {
        return reduce50;
    }

    public void setReduce50(int reduce50) {
        this.reduce50 = reduce50;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }
}
