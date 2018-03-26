package com.sunesoft.ecloud.admin.domain;

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
public class Role extends BizEntity {

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

    @ManyToMany(mappedBy = "roleList")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<User> userList = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "compId")
    private Company company;

    private List<RoleMenuRelEntity> roleMenuList = new ArrayList<>();

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


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
