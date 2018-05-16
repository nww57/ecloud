package com.sunesoft.ecloud.caseclient.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 日期
 */
public class XMLDate {

    @XStreamAlias("年")
    private String year;
    @XStreamAlias("月")
    private String month;
    @XStreamAlias("日")
    private String day;

    public XMLDate() {
        this.year = "";
        this.month = "";
        this.day = "";
    }

    public XMLDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
