package com.sunesoft.ecloud.admin.domain.params;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * 参数表
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
@Entity
@Table(name = "sys_parameters", schema = "ecloud", catalog = "")
public class Parameters extends IEntity {

    /**
     *隶属于参数类型的ID
     */
    @JoinColumn(name = "typeId")
    @ManyToOne
    private UUID typeId;

    @JoinColumn(name = "paramName")
    private String paramName;

    @JoinColumn(name = "paramKey")
    private String paramKey;

    @JoinColumn(name = "paramValue")
    private String paramValue;

    @JoinColumn(name = "paramDesc")
    private String paramDesc;

    @JoinColumn(name = "paramSort")
    private Integer paramSort;

    @JoinColumn(name = "remark")
    private String remark;

    @JoinColumn(name = "attr1")
    private String attr1;

    @JoinColumn(name = "attr2")
    private String attr2;

    @JoinColumn(name = "attr3")
    private String attr3;

    @JoinColumn(name = "attr4")
    private String attr4;

    @JoinColumn(name = "attr5")
    private String attr5;

    @JoinColumn(name = "attr6")
    private String attr6;

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

    public String getAttr6() {
        return attr6;
    }

    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }
}
