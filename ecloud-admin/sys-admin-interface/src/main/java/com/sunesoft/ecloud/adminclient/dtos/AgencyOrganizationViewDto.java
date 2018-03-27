package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
public class AgencyOrganizationViewDto extends AgencyOrganizationDto{
    /**
     * 负责人集合
     */
    private List<BasicDto> userList;

    public List<BasicDto> getUserList() {
        return userList;
    }

    public void setUserList(List<BasicDto> userList) {
        this.userList = userList;
    }
}
