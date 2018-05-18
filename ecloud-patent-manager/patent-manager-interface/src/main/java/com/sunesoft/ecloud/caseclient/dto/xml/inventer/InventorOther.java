package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamAlias("其他发明人")
public class InventorOther {

    @XStreamAlias("姓名")
    private String name;

    @XStreamAlias("请求不公开")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean open;

    @XStreamAsAttribute
    @XStreamAlias("顺序")
    private int sort;

    @XStreamAlias("英文姓名")
    private String nameEn;


    public InventorOther(int sort,String name, boolean open) {
        this.name = name;
        this.open = open;
        this.nameEn = "";
        this.sort = sort;
    }
}
