package com.sunesoft.ecloud.files.biz.application.dtos;

import com.sunesoft.ecloud.files.biz.domain.enums.PathType;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/17
 */
public class FileUploadDto {

    /**
     * 如果是覆盖，则需提供覆盖的文件id
     */
    private UUID id;

    /**
     * 是否覆盖
     */
    private Boolean isCovered= false;

    /**
     * 文件要求的路径模板
     */
    private PathType requirePathType;


    /**
     * 业务类型（申请文件/补正文件/等）
     */
    private String bizType;

    /**
     * 根目录
     */
    private String baseRoot;
    /**
     * 文件类型
     */
    private String docType;



    private String remark;

    public Boolean getCovered() {
        return isCovered;
    }

    public void setCovered(Boolean covered) {
        isCovered = covered;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PathType getRequirePathType() {
        return requirePathType;
    }

    public void setRequirePathType(PathType requirePathType) {
        this.requirePathType = requirePathType;
    }
}
