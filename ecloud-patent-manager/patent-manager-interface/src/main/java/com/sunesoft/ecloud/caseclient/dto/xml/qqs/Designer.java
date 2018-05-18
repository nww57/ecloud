package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class Designer {

    @XStreamAlias("第一设计人")
    private InventorFirst first;

    @XStreamImplicit(itemFieldName = "其他设计人")
    private List<InventorOther> otherList;

    public Designer(InventorFirst first, List<InventorOther> otherList) {
        this.first = first;
        this.otherList = otherList;
    }
}
