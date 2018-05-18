package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.StringUtils;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class SimilarDesign {

    @XStreamAlias("附加")
    private int similar;

    @XStreamAlias("相似设计项数")
    private String count;

    public SimilarDesign(boolean similar, String count) {
        this.similar = similar?1:0;
        this.count = StringUtils.isEmpty(count)?"":count;
    }
}
