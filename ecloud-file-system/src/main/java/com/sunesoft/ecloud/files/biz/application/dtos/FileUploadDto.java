package com.sunesoft.ecloud.files.biz.application.dtos;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/17
 */
public class FileUploadDto {

    /**
     * 是否覆盖
     */
    private Boolean isCovered= false;

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



    private InputStream inputStream;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
