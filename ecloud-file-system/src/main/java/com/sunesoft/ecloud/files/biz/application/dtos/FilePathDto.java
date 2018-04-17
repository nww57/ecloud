package com.sunesoft.ecloud.files.biz.application.dtos;

import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
public class FilePathDto {

    private UUID id;

    private String baseRoot;// 存储案件编号

    private String pathName;

    private String pathDesc;

    private Boolean hasParent;


    private List<FilePathDto> childs;


    List<FileInfoDto> listFiles;

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

    public List<FileInfoDto> getListFiles() {
        return listFiles;
    }

    public void setListFiles(List<FileInfoDto> listFiles) {
        this.listFiles = listFiles;
    }
}
