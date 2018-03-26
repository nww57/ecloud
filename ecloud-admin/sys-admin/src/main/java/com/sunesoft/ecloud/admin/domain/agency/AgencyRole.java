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
@Table(name = "sys_role", schema = "ecloud", catalog = "")
public class AgencyRole extends BizEntity {

    /**
     * 名称
     */
    private String name;
    /**
     *code
     */
    private String code;
    /**
     * 描述
     */
    private String description;


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
