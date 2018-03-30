package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/30/030
 */
public class TreeDto<T> {

    private UUID id;

    private UUID pid;

    private List<T> children;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPid() {
        return pid;
    }

    public void setPid(UUID pid) {
        this.pid = pid;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
