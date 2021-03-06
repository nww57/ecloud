package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class Inventor {

    @XStreamAlias("第一发明人")
    private InventorFirst first;

    @XStreamImplicit(itemFieldName = "其他发明人")
    private List<InventorOther> otherList;

    public Inventor(InventorFirst first, List<InventorOther> otherList) {
        this.first = first;
        this.otherList = otherList;
    }


}
