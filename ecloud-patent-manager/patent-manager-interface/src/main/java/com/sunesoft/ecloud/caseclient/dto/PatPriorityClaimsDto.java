package com.sunesoft.ecloud.caseclient.dto;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 优先权项DTO
 */
public class PatPriorityClaimsDto {


    private UUID id;

    private UUID patentId;

    /**
     *原受理机构名称
     */
    private String priorAgencyName;
    /**
     *国别名称
     */
    private String countryName;
    /**
     *国别Code
     */
    private String countryCode;
    /**
     *在先申请日
     */
    private String priorApplicationDate;
    /**
     *在先申请号
     */
    private String priorApplicationNo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatentId() {
        return patentId;
    }

    public void setPatentId(UUID patentId) {
        this.patentId = patentId;
    }

    public String getPriorAgencyName() {
        return priorAgencyName;
    }

    public void setPriorAgencyName(String priorAgencyName) {
        this.priorAgencyName = priorAgencyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPriorApplicationDate() {
        return priorApplicationDate;
    }

    public void setPriorApplicationDate(String priorApplicationDate) {
        this.priorApplicationDate = priorApplicationDate;
    }

    public String getPriorApplicationNo() {
        return priorApplicationNo;
    }

    public void setPriorApplicationNo(String priorApplicationNo) {
        this.priorApplicationNo = priorApplicationNo;
    }
}
