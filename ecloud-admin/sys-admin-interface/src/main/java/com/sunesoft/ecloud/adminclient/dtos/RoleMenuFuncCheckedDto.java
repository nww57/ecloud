package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 *菜单功能
 */
public class RoleMenuFuncCheckedDto {

    /**
     * id
     */
    private UUID id;

    /**
     *名称
     */
    private String name;

    /**
     *是否选中
     */
    private boolean checked;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
