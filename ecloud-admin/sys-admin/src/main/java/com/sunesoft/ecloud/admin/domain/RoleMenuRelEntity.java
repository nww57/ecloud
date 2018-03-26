package com.sunesoft.ecloud.admin.domain;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Auther: niww
 * @Date: 2018/3/26/026
 */
public class RoleMenuRelEntity extends IEntity{

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "menuId",referencedColumnName = "menuId")
    private CompanyMenuRelEntity companyMenu;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public CompanyMenuRelEntity getCompanyMenu() {
        return companyMenu;
    }

    public void setCompanyMenu(CompanyMenuRelEntity companyMenu) {
        this.companyMenu = companyMenu;
    }
}
