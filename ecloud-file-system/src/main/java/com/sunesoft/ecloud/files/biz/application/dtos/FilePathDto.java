package com.sunesoft.ecloud.files.biz.application.dtos;

import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.AliasName;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.FieldWithoutCheck;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
public class FilePathDto {

    private UUID id;

    private UUID agId;

    private String baseRoot;// 存储案件编号

    private String pathName;

    private String pathDesc;

    private Boolean hasParent;

    private String pathIndex;

    private Boolean isTempleteData;

    private PathType pathType;

    @AliasName("parent_id")
    @FieldWithoutCheck
    private UUID parentId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBaseRoot() {
        return baseRoot;
    }

    public void setBaseRoot(String baseRoot) {
        this.baseRoot = baseRoot;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getPathDesc() {
        return pathDesc;
    }

    public void setPathDesc(String pathDesc) {
        this.pathDesc = pathDesc;
    }

    public Boolean getHasParent() {
        return hasParent;
    }

    public void setHasParent(Boolean hasParent) {
        this.hasParent = hasParent;
    }


    public String getPathIndex() {
        return pathIndex;
    }

    public void setPathIndex(String pathIndex) {
        this.pathIndex = pathIndex;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public Boolean getTempleteData() {
        return isTempleteData;
    }

    public void setTempleteData(Boolean templeteData) {
        isTempleteData = templeteData;
    }

    public PathType getPathType() {
        return pathType;
    }

    public void setPathType(PathType pathType) {
        this.pathType = pathType;
    }
}
