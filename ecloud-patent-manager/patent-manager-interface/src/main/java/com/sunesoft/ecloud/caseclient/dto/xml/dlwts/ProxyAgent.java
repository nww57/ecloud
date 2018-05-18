package com.sunesoft.ecloud.caseclient.dto.xml.dlwts;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 代理委托书-代理人信息
 */
@XStreamAlias("指定代理人")
public class ProxyAgent {

    @XStreamAlias("姓名")
    private String name;

    @XStreamAsAttribute
    @XStreamAlias("顺序")
    private int sort;

    public ProxyAgent(String name, int sort) {
        this.name = name;
        this.sort = sort;
    }

}
