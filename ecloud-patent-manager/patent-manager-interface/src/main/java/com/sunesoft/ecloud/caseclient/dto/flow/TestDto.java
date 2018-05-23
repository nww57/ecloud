package com.sunesoft.ecloud.caseclient.dto.flow;

import java.io.Serializable;

/**
 * @auther: niww
 * @date: 2018/5/22/022
 */
public class TestDto implements Serializable {

    private int days;

    public TestDto(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
