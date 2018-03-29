package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;
import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 * 角色菜单权限
 */
public class AgencyRoleMenuDto extends BasicDto{


    /**
     * 功能id
     */
    private List<BasicDto> funcList;

    public List<BasicDto> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<BasicDto> funcList) {
        this.funcList = funcList;
    }
}
