package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;

/**
 * Created by jzj on 2018/3/26.
 */
public class AgencyOrganizationListDto extends AgencyOrganizationDto{
    /**
     * 下级机构
     */
    private List<AgencyOrganizationDto> childList;

    public List<AgencyOrganizationDto> getChildList() {
        return childList;
    }

    public void setChildList(List<AgencyOrganizationDto> childList) {
        this.childList = childList;
    }
}
