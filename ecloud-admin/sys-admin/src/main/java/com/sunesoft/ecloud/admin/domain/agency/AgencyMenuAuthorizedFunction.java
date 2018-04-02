package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Auther: niww
 * @Date: 2018/3/26/026
 * 角色菜单权限项配置
 */
@Entity
@Table(name = "sys_ag_menu_authfunc")
public class AgencyMenuAuthorizedFunction extends IEntity{

    /**
     * 菜单功能
     */
    @ManyToOne
    @JoinColumn(name = "funcId")
    private MenuFunction menuFunction;

    public MenuFunction getMenuFunction() {
        return menuFunction;
    }

    public void setMenuFunction(MenuFunction menuFunction) {
        this.menuFunction = menuFunction;
    }
}
