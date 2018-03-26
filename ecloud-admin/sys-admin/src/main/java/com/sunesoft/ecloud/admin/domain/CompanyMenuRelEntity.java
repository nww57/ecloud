package com.sunesoft.ecloud.admin.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业菜单权限
 */
@Entity
@Table(name = "sys_company_menu_rel", schema = "ecloud", catalog = "")
public class CompanyMenuRelEntity extends IEntity{

    @ManyToOne
    @JoinColumn(name = "compId")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "menuId")
    private Menu menu;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RoleMenuRelEntity> roleMenuList = new ArrayList<>();

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<RoleMenuRelEntity> getRoleMenuList() {
        return roleMenuList;
    }

    public void setRoleMenuList(List<RoleMenuRelEntity> roleMenuList) {
        this.roleMenuList = roleMenuList;
    }
}
