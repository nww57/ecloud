package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/16/016
 */
public class AgencyCustomerBasicDto {

    /**
     * 客户id
     */
    private UUID id;

    /**
     * 客户名
     */
    private String name;

    /**
     * 负责人姓名
     */
    private String leaderName;

    /**
     * 业务顾问
     */
    private String consultantName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }
}
