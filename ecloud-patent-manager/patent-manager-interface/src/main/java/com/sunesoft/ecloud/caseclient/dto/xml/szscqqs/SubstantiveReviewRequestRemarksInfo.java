package com.sunesoft.ecloud.caseclient.dto.xml.szscqqs;

import com.sunesoft.ecloud.caseclient.dto.xml.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class SubstantiveReviewRequestRemarksInfo {

    @XStreamAlias("该申请为PCT国际申请实审费不予减免")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean noReduce;

    @XStreamAlias("该申请为PCT国际申请由EPJPSE作出国际检索报告的实审费减免百分之二十")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean reduce20;

    @XStreamAlias("该申请为PCT国际申请由CN作出国际检索报告的实审费减免百分之五十")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean reduce50;

    @XStreamAlias("其他情况")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean other;

    public SubstantiveReviewRequestRemarksInfo() {
    }

    public SubstantiveReviewRequestRemarksInfo(boolean noReduce, boolean reduce20, boolean reduce50, boolean other) {
        this.noReduce = noReduce;
        this.reduce20 = reduce20;
        this.reduce50 = reduce50;
        this.other = other;
    }

    public boolean getNoReduce() {
        return noReduce;
    }

    public void setNoReduce(boolean noReduce) {
        this.noReduce = noReduce;
    }

    public boolean getReduce20() {
        return reduce20;
    }

    public void setReduce20(boolean reduce20) {
        this.reduce20 = reduce20;
    }

    public boolean getReduce50() {
        return reduce50;
    }

    public void setReduce50(boolean reduce50) {
        this.reduce50 = reduce50;
    }

    public boolean getOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }
}
