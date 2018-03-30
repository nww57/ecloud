package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.BizEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 角色信息
 */
@Entity
@Table(name = "sys_ag_role")
public class AgencyRole extends BizEntity {

    /**
     * 名称
     */
    @Column(name="name")
    private String name;
    /**
     *code
     */
    @Column(name="code")
    private String code;
    /**
     * 描述
     */
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "agId")
    private Agency agency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
