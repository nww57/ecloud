package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/3/26/026
 */
public class AgencyRoleAuthorizedMenu extends IEntity {

    @ManyToOne
    @JoinColumn(name = "roleId")
    private AgencyRole role;

    @ManyToOne
    @JoinColumn(name = "menuId", referencedColumnName = "menuId")
    private AgencyAuthorizedMenu companyMenu;

    @OneToMany
    @JoinColumn(name = "roleMenuId")
    private List<AgencyMenuAuthorizedFunction> roleMenuFunctionEntities;

    public AgencyRole getRole() {
        return role;
    }

    public void setRole(AgencyRole role) {
        this.role = role;
    }

    public AgencyAuthorizedMenu getCompanyMenu() {
        return companyMenu;
    }

    public void setCompanyMenu(AgencyAuthorizedMenu companyMenu) {
        this.companyMenu = companyMenu;
    }
}
