package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.sunesoft.ecloud.caseclient.dto.xml.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamConverter(value = AdditionalConverter.class)
public class NoveltyStatement {

    @XStreamAlias("已在中国政府主办或承认的国际展览会上首次展出")
    private boolean internationalExhibition;

    @XStreamAlias("已在规定的学术会议或技术会议上首次发表")
    private boolean academicConference;

    @XStreamAlias("他人未经申请人同意而泄露其内容")
    private boolean leakage;

    public NoveltyStatement() {
    }

    public NoveltyStatement(boolean internationalExhibition, boolean academicConference, boolean leakage) {
        this.internationalExhibition = internationalExhibition;
        this.academicConference = academicConference;
        this.leakage = leakage;
    }
}
