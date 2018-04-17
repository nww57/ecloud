package com.sunesoft.ecloud.files.biz.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="file_info")
public class FileInfos extends BizEntity {

    private String baseRoot;
    /**
     * 业务类型（如申请文件/补正文件/等）
     */
    private String bizType;

    /**
     * 文件类型
     */
    private String docType;

    private Integer typeFileCount;
     /**
     * 扩展名
     */
    private String extensions;
    /**
     * 文件大小
     */
    private Integer fileSize;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 版本号(20180416-01)
     */
    private String versionNo;
    /**
     * 是否最新版本
     */
    private Boolean is_latestVersion;

    private String md5;
    /**
     * 文件路径
     */
    @ManyToOne
    @JoinColumn(name="file_path_id")
    private FilePath filePath;

    private String remark;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    public String getExtensions() {
        return extensions;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FilePath getFilePath() {
        return filePath;
    }

    public void setFilePath(FilePath filePath) {
        this.filePath = filePath;
    }

    public String getBaseRoot() {
        return baseRoot;
    }

    public void setBaseRoot(String baseRoot) {
        this.baseRoot = baseRoot;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Boolean getIs_latestVersion() {
        return is_latestVersion;
    }

    public void setIs_latestVersion(Boolean is_latestVersion) {
        this.is_latestVersion = is_latestVersion;
    }

    public Integer getTypeFileCount() {
        return typeFileCount;
    }

    public void setTypeFileCount(Integer typeFileCount) {
        this.typeFileCount = typeFileCount;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }
}
