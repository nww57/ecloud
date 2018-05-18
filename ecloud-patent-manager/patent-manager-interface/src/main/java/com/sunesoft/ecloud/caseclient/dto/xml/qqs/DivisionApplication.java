package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class DivisionApplication {

    @XStreamAlias("原申请号")
    private String preApplicationNo;

    @XStreamAlias("针对的分案申请号")
    private String toApplicationNo;

    @XStreamAlias("原申请日")
    private XMLDate preApplicationDate;

    public DivisionApplication() {
        this.preApplicationNo = "";
        this.toApplicationNo = "";
        this.preApplicationDate = new XMLDate();
    }

    public DivisionApplication(String preApplicationNo, String toApplicationNo, XMLDate preApplicationDate) {
        this.preApplicationNo = preApplicationNo;
        this.toApplicationNo = toApplicationNo;
        this.preApplicationDate = preApplicationDate;
    }
}
