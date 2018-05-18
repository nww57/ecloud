package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.converter.AdditionalConverter;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public boolean getStatementInfoIdentical() {
        return statementInfoIdentical;
    }

    public void setStatementInfoIdentical(boolean statementInfoIdentical) {
        this.statementInfoIdentical = statementInfoIdentical;
    }

    public List<AgencyAgent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<AgencyAgent> agentList) {
        this.agentList = agentList;
    }
}
