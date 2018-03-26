package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.util.*;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业菜单权限
 */
@Entity
@Table(name = "sys_company_menu_rel", schema = "ecloud", catalog = "")
public class AgencyAuthorizedMenu extends IEntity {

    private UUID agencyId;

    @ManyToOne
    @JoinColumn(name = "menuId")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public UUID getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(UUID agencyId) {
        this.agencyId = agencyId;
    }

}
