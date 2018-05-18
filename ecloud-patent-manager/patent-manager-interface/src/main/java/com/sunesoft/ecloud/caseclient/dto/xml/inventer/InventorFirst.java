package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class InventorFirst {

    @XStreamAlias("姓名")
    private String name;

    @XStreamAlias("请求不公开")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean open;

    @XStreamAlias("国籍")
    private String countryCode;

    @XStreamAlias("身份证号")
    private String idCode;

    @XStreamAlias("英文姓名")
    private String nameEn;

    public InventorFirst(String name, String countryCode, boolean open, String idCode) {
        this.name = name;
        this.countryCode = countryCode;
        this.open = open;
        this.idCode = idCode;
        this.nameEn = "";
    }
}
