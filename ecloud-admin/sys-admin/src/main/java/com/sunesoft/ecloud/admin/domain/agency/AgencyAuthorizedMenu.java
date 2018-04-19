package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业菜单权限
 */
@Entity
@Table(name = "sys_ag_authmenu")
public class AgencyAuthorizedMenu extends IEntity {

    /**
     * 机构id
     */
    @Column(name = "agId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID agencyId;

    /**
     * 菜单
     */
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
