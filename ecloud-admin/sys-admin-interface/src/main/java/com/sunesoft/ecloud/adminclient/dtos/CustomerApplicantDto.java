package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.ApplicantType;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户申请人操作dto
 */
public class CustomerApplicantDto {

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
     *申请人类型
     */
    private ApplicantType type;


    /**
     *身份证/机构代码
     */
    private String code;


    /**
     *是否通过国知局费减备案
     */
    private Boolean record;


    /**
     *备案有效期
     */
    private LocalDateTime recordValidDate;


    /**
     *地区
     */
    private String area;


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

    public ApplicantType getType() {
        return type;
    }

    public void setType(ApplicantType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getRecord() {
        return record;
    }

    public void setRecord(Boolean record) {
        this.record = record;
    }

    public LocalDateTime getRecordValidDate() {
        return recordValidDate;
    }

    public void setRecordValidDate(LocalDateTime recordValidDate) {
        this.recordValidDate = recordValidDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
