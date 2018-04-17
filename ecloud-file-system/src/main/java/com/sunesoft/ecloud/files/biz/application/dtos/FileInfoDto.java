package com.sunesoft.ecloud.files.biz.application.dtos;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
public class FileInfoDto {

    private UUID id;


    private UUID agId;

    /**
     * 是否覆盖
     */
    private Boolean isCovered= false;

    /**
     * 业务类型（申请文件/补正文件/等）
     */
    private String bizType;


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
    private Integer fileSize;

    /**
     * 文件名
     */
    private String fileName;



    private String md5;
    /**
     * 文件路径
     */
    private UUID filePathId;


    private Integer downLoadCount;

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

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
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

    public UUID getFilePathId() {
        return filePathId;
    }

    public void setFilePathId(UUID filePathId) {
        this.filePathId = filePathId;
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
}
