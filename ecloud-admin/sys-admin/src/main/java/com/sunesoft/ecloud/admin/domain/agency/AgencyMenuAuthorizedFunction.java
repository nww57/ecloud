package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Auther: niww
 * @Date: 2018/3/26/026
 * 角色菜单权限项配置
 */
public class AgencyMenuAuthorizedFunction extends IEntity{

    @ManyToOne
    @JoinColumn(name = "funcId")
    private MenuFunction menuFunction;

}
