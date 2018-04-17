package com.sunesoft.ecloud.files.biz.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="file_path")
public class FilePath extends BizEntity {

    private String baseRoot;// 存储案件编号

    private String pathCode;

    private String pathName;

    private String pathDesc;

    private Boolean hasParent;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private FilePath parent;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @JoinColumn(name="parent_id")
    private List<FilePath> childPaths;



    private Boolean isTempleteData;

    public FilePath(){
        this.setIs_active(true);
        this.setCreate_datetime(LocalDateTime.now());
        this.setLast_update_time(LocalDateTime.now());

    }

    public Boolean getHasParent() {
        return hasParent;
    }

    public void setHasParent(Boolean hasParent) {
        this.hasParent = hasParent;
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

    public List<FilePath> getChildPaths() {
        return childPaths;
    }

    public void setChildPaths(List<FilePath> childPaths) {
        this.childPaths = childPaths;
    }


    public FilePath getParent() {
        return parent;
    }

    public void setParent(FilePath parent) {
        this.parent = parent;
    }

    public String getBaseRoot() {
        return baseRoot;
    }

    public void setBaseRoot(String baseRoot) {
        this.baseRoot = baseRoot;
    }

    public Boolean getTempleteData() {
        return isTempleteData;
    }

    public void setTempleteData(Boolean templeteData) {
        isTempleteData = templeteData;
    }

    public String getPathCode() {
        return pathCode;
    }

    public void setPathCode(String pathCode) {
        this.pathCode = pathCode;
    }
}