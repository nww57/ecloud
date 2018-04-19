package com.sunesoft.ecloud.files.biz.application.dtos;

import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.AliasName;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.FieldWithoutCheck;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.SqlIgnore;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
public class FileInfoForDownLoadDto {

    private UUID id;


    private UUID agId;



    @SqlIgnore
    private PathType requirePathType;
    /**
     * 是否覆盖
     */
    @SqlIgnore
    private Boolean isCovered= false;

    /**
     * 业务类型（申请文件/补正文件/等）
     */
    private String bizType;

    @SqlIgnore
    private InputStream inputStream;


    private String baseRoot;
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
    private Long fileSize;

    /**
     * 文件名
     */
    private String fileName;



    private String md5;
    /**
     * 文件路径
     */
    @AliasName("file_path_id")
    @FieldWithoutCheck
    private UUID file_path_id;


    private Integer downLoadCount;


    /**
     * 版本号(20180416-01)
     */
    private String versionNo;



    private String realPath;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
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

    public String getExtensions() {
        return extensions;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }

    public Boolean getCovered() {
        return isCovered;
    }

    public void setCovered(Boolean covered) {
        isCovered = covered;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public UUID getFile_path_id() {
        return file_path_id;
    }

    public void setFile_path_id(UUID file_path_id) {
        this.file_path_id = file_path_id;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Integer getTypeFileCount() {
        return typeFileCount;
    }

    public void setTypeFileCount(Integer typeFileCount) {
        this.typeFileCount = typeFileCount;
    }

    public Integer getDownLoadCount() {
        return downLoadCount;
    }

    public void setDownLoadCount(Integer downLoadCount) {
        this.downLoadCount = downLoadCount;
    }

    public PathType getRequirePathType() {
        return requirePathType;
    }

    public void setRequirePathType(PathType requirePathType) {
        this.requirePathType = requirePathType;
    }


    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }
}
