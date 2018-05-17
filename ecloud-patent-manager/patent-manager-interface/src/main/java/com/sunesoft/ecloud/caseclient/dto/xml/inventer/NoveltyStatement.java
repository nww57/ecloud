package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamConverter(value = AdditionalConverter.class)
public class NoveltyStatement {

    @XStreamAlias("已在中国政府主办或承认的国际展览会上首次展出")
    private int internationalExhibition;

    @XStreamAlias("已在中国政府主办或承认的国际展览会上首次展出")
    private int academicConference;

    @XStreamAlias("他人未经申请人同意而泄露其内容")
    private int leakage;

    public NoveltyStatement() {
    }

    public NoveltyStatement(int internationalExhibition, int academicConference, int leakage) {
        this.internationalExhibition = internationalExhibition;
        this.academicConference = academicConference;
        this.leakage = leakage;
    }
}
