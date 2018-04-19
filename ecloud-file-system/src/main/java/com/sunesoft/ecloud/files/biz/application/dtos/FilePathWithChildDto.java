package com.sunesoft.ecloud.files.biz.application.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
public class FilePathWithChildDto {

    private UUID id;

    private String baseRoot;// 存储案件编号

    private String pathName;

    private String pathDesc;

    private Boolean hasParent;


    private List<FilePathWithChildDto> childs= new ArrayList<>();


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

    public List<FilePathWithChildDto> getChilds() {
        return childs;
    }

    public void setChilds(List<FilePathWithChildDto> childs) {
        this.childs = childs;
    }
}
