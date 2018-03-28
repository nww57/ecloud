package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 * 角色菜单
 */
public class RoleMenuCheckedDto {

    /**
     * 菜单id
     */
    private UUID id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     *是否选中
     */
    private boolean checked;

    /**
     *父级id
     */
    private UUID parentId;

    /**
     *菜单功能
     */
    private List<RoleMenuFuncCheckedDto> funcList;

    /**
     *下级菜单
     */
    private List<RoleMenuCheckedDto> childList;

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

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public List<RoleMenuFuncCheckedDto> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<RoleMenuFuncCheckedDto> funcList) {
        this.funcList = funcList;
    }

    public List<RoleMenuCheckedDto> getChildList() {
        return childList;
    }

    public void setChildList(List<RoleMenuCheckedDto> childList) {
        this.childList = childList;
    }
}
