package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamAlias("代理人")
public class AgencyAgent {

    @XStreamAlias("姓名")
    private String name;

    @XStreamAlias("工作证号")
    private String workNo;

    @XStreamAlias("电话")
    private String phone;

    @XStreamAlias("顺序")
    @XStreamAsAttribute
    private int sort;

    public AgencyAgent( int sort,String name, String workNo, String phone) {
        this.name = name;
        this.workNo = workNo;
        this.phone = phone;
        this.sort = sort;
    }
}
