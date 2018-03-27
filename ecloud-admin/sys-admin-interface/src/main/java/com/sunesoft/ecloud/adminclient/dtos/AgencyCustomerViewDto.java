package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
public class AgencyCustomerViewDto extends AgencyCustomerDto {
    /**
     * 业务顾问集合
     */
    private List<BasicDto> consultantList;


    public List<BasicDto> getConsultantList() {
        return consultantList;
    }

    public void setConsultantList(List<BasicDto> consultantList) {
        this.consultantList = consultantList;
    }
}
