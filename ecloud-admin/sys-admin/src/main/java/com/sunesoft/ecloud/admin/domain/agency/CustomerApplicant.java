package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.adminclient.ApplicantType;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户申请人维护
 */
@Entity
@Table(name = "customer_applicant")
public class CustomerApplicant extends IEntity{

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
     *申请人类型
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ApplicantType type;


    /**
     *身份证/机构代码
     */
    @Column(name = "code")
    private String code;


    /**
     *是否通过国知局费减备案
     */
    @Column(name = "record")
    private Boolean record;


    /**
     *备案有效期
     */
    @Column(name = "recordValidDate")
    private LocalDateTime recordValidDate;


    /**
     *地区
     */
    @Column(name = "area")
    private String area;


    /**
     * 所属客户
     */
    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
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
