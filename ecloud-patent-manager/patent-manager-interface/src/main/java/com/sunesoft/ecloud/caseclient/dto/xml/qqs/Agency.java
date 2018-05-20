package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.sunesoft.ecloud.caseclient.dto.xml.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class Agency {

    @XStreamAlias("名称")
    private String name;

    @XStreamAlias("代码")
    private String agencyCode;

    /**
     * 该字段在外观专利请求书中要忽略
     */
    @XStreamAlias("声明已经与申请人签订了专利代理委托书且本表中的信息与委托书中相应信息一致")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean statementInfoIdentical;

    @XStreamImplicit
    private List<AgencyAgent> agentList;

    public Agency(String name, String agencyCode, boolean statementInfoIdentical, List<AgencyAgent> agentList) {
        this.name = name;
        this.agencyCode = agencyCode;
        this.statementInfoIdentical = statementInfoIdentical;
        this.agentList = agentList;
    }
}
