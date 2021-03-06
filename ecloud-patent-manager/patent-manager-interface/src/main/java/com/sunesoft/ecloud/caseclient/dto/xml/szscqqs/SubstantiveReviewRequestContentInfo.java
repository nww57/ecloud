package com.sunesoft.ecloud.caseclient.dto.xml.szscqqs;

import com.sunesoft.ecloud.caseclient.dto.xml.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class SubstantiveReviewRequestContentInfo {

    @XStreamAlias("声明本申请人放弃专利主动修改权利")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean  giveUp ;

    public SubstantiveReviewRequestContentInfo(boolean giveUp) {
        this.giveUp = giveUp;
    }
}
