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
    private List<BasicDto> funcId;

    public List<BasicDto> getFuncId() {
        return funcId;
    }

    public void setFuncId(List<BasicDto> funcId) {
        this.funcId = funcId;
    }
}
