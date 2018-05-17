package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamAlias("在先申请")
public class PriorItem {

    @XStreamAlias("顺序")
    @XStreamAsAttribute
    private int sort;

    @XStreamAlias("在先申请国别或地区")
    private String preAgencyName;

    @XStreamAlias("在先申请日")
    private String preApplicationDate;

    @XStreamAlias("在先申请号")
    private String preApplicationNo;

    public PriorItem(int sort) {
        this.sort = sort;
        this.preAgencyName = "";
        this.preApplicationDate = "";
        this.preApplicationNo = "";
    }

    public PriorItem(int sort, String preAgencyName, String preApplicationDate, String preApplicationNo) {
        this.sort = sort;
        this.preAgencyName = preAgencyName;
        this.preApplicationDate = preApplicationDate;
        this.preApplicationNo = preApplicationNo;
    }
}
