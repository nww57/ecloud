package com.sunesoft.ecloud.common;

import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.FieldWithoutCheck;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/29 下午6:47
 * -
 */
public abstract class TreeEntity {
    private UUID id;

    @FieldWithoutCheck
    private UUID pid;


    public abstract List getChildren();

    public abstract void setChildren(List list);

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



}
