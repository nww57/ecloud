package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class ApplySameDay {

    @XStreamAlias("声明本发明在同日申请实用新型专利")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean applySameDay;

    public ApplySameDay(boolean applySameDay) {
        this.applySameDay = applySameDay;
    }
}
