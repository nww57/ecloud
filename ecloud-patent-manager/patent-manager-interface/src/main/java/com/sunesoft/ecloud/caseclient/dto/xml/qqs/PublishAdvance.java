package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.sunesoft.ecloud.caseclient.dto.xml.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class PublishAdvance {

    @XStreamAlias("请求早日公布该专利申请")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean publishAdvance;


    public PublishAdvance(boolean publishAdvance) {
        this.publishAdvance = publishAdvance;
    }
}
