package com.sunesoft.ecloud.caseclient.dto.xml.examine;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class SubstantiveReviewRequestContentInfo {

    @XStreamAlias("声明本申请人放弃专利主动修改权利")
    private int  giveUp = 1;

    public SubstantiveReviewRequestContentInfo(int giveUp) {
        this.giveUp = giveUp;
    }
}
