package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.sunesoft.ecloud.caseclient.dto.xml.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class GeneticResources {

    @XStreamAlias("本专利申请涉及的发明创造是依赖于遗传资源完成的")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean geneticResources;

    public GeneticResources(boolean geneticResources) {
        this.geneticResources = geneticResources;
    }
}
