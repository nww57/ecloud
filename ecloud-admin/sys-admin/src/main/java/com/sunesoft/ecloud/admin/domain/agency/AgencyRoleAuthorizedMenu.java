package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/3/26/026
 * 角色的菜单权限
 */
@Entity
@Table(name="sys_ag_role_authmenu")
public class AgencyRoleAuthorizedMenu extends IEntity {

    @ManyToOne
    @JoinColumn(name = "roleId")
    private AgencyRole role;

    @ManyToOne
    @JoinColumn(name = "menuId")
    private AgencyAuthorizedMenu agencyMenu;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "roleMenuId")
    private List<AgencyMenuAuthorizedFunction> roleMenuFunctionEntities;

    public AgencyRole getRole() {
        return role;
    }

    public void setRole(AgencyRole role) {
        this.role = role;
    }

    public AgencyAuthorizedMenu getAgencyMenu() {
        return agencyMenu;
    }

    public void setAgencyMenu(AgencyAuthorizedMenu agencyMenu) {
        this.agencyMenu = agencyMenu;
    }

    public List<AgencyMenuAuthorizedFunction> getRoleMenuFunctionEntities() {
        return roleMenuFunctionEntities;
    }

    public void setRoleMenuFunctionEntities(List<AgencyMenuAuthorizedFunction> roleMenuFunctionEntities) {
        this.roleMenuFunctionEntities = roleMenuFunctionEntities;
    }
}
