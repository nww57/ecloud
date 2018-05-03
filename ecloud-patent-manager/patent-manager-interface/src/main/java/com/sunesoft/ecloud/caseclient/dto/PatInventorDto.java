package com.sunesoft.ecloud.caseclient.dto;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 */
public class PatInventorDto {


    private UUID id;

    private UUID patentId;

    /**
     * 姓名
     */
    private String name;

    /**
     *国家code
     */
    private String countryCode;

    /**
     *国家name
     */
    private String countryName;

    /**
     *身份证
     */
    private String idCode;

    /**
     *是否公开
     */
    private Boolean open;


    /**
     * 联系方式
     */
    private String cellphone;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
