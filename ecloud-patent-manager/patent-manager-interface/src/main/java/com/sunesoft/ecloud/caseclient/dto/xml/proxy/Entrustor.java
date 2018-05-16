package com.sunesoft.ecloud.caseclient.dto.xml.proxy;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 代理委托书-委托人签章信息
 */
@XStreamAlias("委托人签章")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"name"})
public class Entrustor {

    private String name;

    @XStreamAsAttribute
    @XStreamAlias("顺序")
    private int sort;

    public Entrustor(String name, int sort) {
        this.name = name;
        this.sort = sort;
    }

}
