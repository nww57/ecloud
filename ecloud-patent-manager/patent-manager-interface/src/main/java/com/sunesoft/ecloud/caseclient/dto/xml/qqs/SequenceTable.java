package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.sunesoft.ecloud.caseclient.dto.xml.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class SequenceTable {

    @XStreamAlias("本申请涉及核苷酸或氨基酸序列表")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean involve;

    public SequenceTable(boolean involve) {
        this.involve = involve;
    }
}
