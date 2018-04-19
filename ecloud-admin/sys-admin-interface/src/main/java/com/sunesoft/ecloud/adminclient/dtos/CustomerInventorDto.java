package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户发明人操作dto
 */
public class CustomerInventorDto {

    private UUID id;
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
     *身份证/机构代码
     */
    private String code;

    /**
     *是否公开
     */
    private Boolean open;


    /**
     * 所属客户
     */
    private UUID customerId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}