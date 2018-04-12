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
     *国家
     */
    private String country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
