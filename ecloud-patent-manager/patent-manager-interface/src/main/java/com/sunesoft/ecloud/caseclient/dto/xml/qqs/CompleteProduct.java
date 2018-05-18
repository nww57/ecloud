package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.StringUtils;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class CompleteProduct {

    @XStreamAlias("附加")
    private int completeProduct;

    @XStreamAlias("成套产品项数")
    private String count;

    public CompleteProduct(boolean completeProduct, String count) {
        this.completeProduct = completeProduct?1:0;
        this.count = StringUtils.isEmpty(count)?"":count;
    }
}
