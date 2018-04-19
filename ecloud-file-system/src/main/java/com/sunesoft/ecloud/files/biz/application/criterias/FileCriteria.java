package com.sunesoft.ecloud.files.biz.application.criterias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.utils.StringUtil;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
public class FileCriteria extends TCretiria{

    private UUID agId;
    /**
     * 根目录
     */
    private String baseRoot;
    /**
     * 业务类型（申请文件/补正文件/等）
     */
    private String bizType;
    /**
     * 文件类型
     */
    private String docType;

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getBaseRoot() {
        return baseRoot;
    }

    public void setBaseRoot(String baseRoot) {
        this.baseRoot = baseRoot;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
    public Map<String, Object> getParams() {

        Map<String, Object> params = new HashMap<>();

        if(agId!=null){
            params.put("agId",agId.toString());
        }
        if(!StringUtil.isEmpty(baseRoot)){
            params.put("baseRoot",baseRoot);
        }
        if(!StringUtil.isEmpty(bizType)){
            params.put("bizType",bizType);
        }
        if(!StringUtil.isEmpty(docType)){
            params.put("docType",docType);
        }
        return params;
    }



}
