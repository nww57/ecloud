package com.sunesoft.ecloud.adminclient.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:14
 * -
 */
public class ParameterDto {

    private  UUID id;

    /**
     * 类型ID
     */
    private UUID typeId;

    /**
     * 参数名
     */
    private String paramName;

    /**
     * 参数键（这里是否可理解为参数编码，待确认）
     */
    private String paramKey;

    /**
     * 参数值
     */
    private String paramValue;

    /**
     * 参数描述
     */
    private String paramDesc;

    /**
     * 参数序号
     */
    private Integer paramSort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 默认显示（中文显示）
     */
    private String defaultDisplay;

    /**
     * 英文显示
     */
    private String englishDisplay;

    /**
     * 最后更新人
     */
    private String renewing;

    /**
     * 最后更新人Id
     */
    private String renewingId;

    /**
     * 最后更新时间
     */
    private LocalDateTime last_update_time;

    private String attr6;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTypeId() {
        return typeId;
    }

    public void setTypeId(UUID typeId) {
        this.typeId = typeId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    public Integer getParamSort() {
        return paramSort;
    }

    public void setParamSort(Integer paramSort) {
        this.paramSort = paramSort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDefaultDisplay() {
        return defaultDisplay;
    }

    public void setDefaultDisplay(String defaultDisplay) {
        this.defaultDisplay = defaultDisplay;
    }

    public String getEnglishDisplay() {
        return englishDisplay;
    }

    public void setEnglishDisplay(String englishDisplay) {
        this.englishDisplay = englishDisplay;
    }

    public String getRenewing() {
        return renewing;
    }

    public void setRenewing(String renewing) {
        this.renewing = renewing;
    }

    public String getRenewingId() {
        return renewingId;
    }

    public void setRenewingId(String renewingId) {
        this.renewingId = renewingId;
    }

    public LocalDateTime getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(LocalDateTime last_update_time) {
        this.last_update_time = LocalDateTime.now();
    }

    public String getAttr6() {
        return attr6;
    }

    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }
}
