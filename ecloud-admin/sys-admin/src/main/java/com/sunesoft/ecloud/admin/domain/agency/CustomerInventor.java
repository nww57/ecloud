package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.adminclient.ApplicantType;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户发明人维护
 */
@Entity
@Table(name = "customer_inventor")
public class CustomerInventor extends IEntity{

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     *国家
     */
    @Column(name = "country")
    private String country;

    /**
     *身份证/机构代码
     */
    @Column(name = "code")
    private String code;

    /**
     *是否公开
     */
    @Column(name = "open")
    private Boolean open;


    /**
     * 所属客户
     */
    @Column(name = "customerId")
    private UUID customerId;

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