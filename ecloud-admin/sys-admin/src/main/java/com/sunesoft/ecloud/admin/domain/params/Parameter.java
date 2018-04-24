package com.sunesoft.ecloud.admin.domain.params;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.util.UUID;

/**
 * 参数表
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
@Entity
@Table(name = "sys_parameter", schema = "ecloud", catalog = "")
public class Parameter extends IEntity {

    /**
     *隶属于参数类型
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parameterId")
    private ParameterType parameterType;

    /**
     * 参数名
     */
    @Column(name = "paramName")
    private String paramName;

    /**
     *参数键（这里是否可理解为参数编码，待确认）
     */
    @Column(name = "paramKey")
    private String paramKey;

    /**
     *参数值
     */
    @Column(name = "paramValue")
    private String paramValue;

    /**
     *参数描述
     */
    @Column(name = "paramDesc")
    private String paramDesc;

    /**
     *参数排序
     */
    @Column(name = "paramSort")
    private Integer paramSort;

    /**
     *备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 默认显示（中文显示）
     */
    @Column(name = "defaultDisplay")
    private String defaultDisplay;

    /**
     * 英文显示
     */
    @Column(name = "englishDisplay")
    private String englishDisplay;

    /**
     * 最后更新人
     */
    @Column(name = "renewing")
    private String renewing;

    /**
     * 最后更新人Id
     */
    @Column(name = "renewingId")
    private String renewingId;

    @Column(name = "attr5")
    private String attr5;

    @Column(name = "attr6")
    private String attr6;

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
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

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    public String getAttr6() {
        return attr6;
    }

    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }
}
