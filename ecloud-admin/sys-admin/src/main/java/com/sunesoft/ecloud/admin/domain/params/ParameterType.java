package com.sunesoft.ecloud.admin.domain.params;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 参数类型表
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
@Entity
@Table(name = "sys_parameter_type", schema = "ecloud", catalog = "")
public class ParameterType extends IEntity {

    @Column(name = "paramTypeName")
    private String paramTypeName;

    @Column(name = "paramTypeCode")
    private String paramTypeCode;

    @Column(name = "paramTypeDesc")
    private String paramTypeDesc;

    @Column(name = "remark")
    private String remark;

    /**
     *参数类型关联参数
     */
    @OneToMany(mappedBy = "parameterType")
    private List<Parameter> parameterList;

    /**
     *参数类型父节点
     */
    @ManyToOne
    @JoinColumn(name = "pid")
    private ParameterType parentParamType;

    /**
     *参数类型子节点
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "parentParamType")
    private List<ParameterType> children = new ArrayList<>();

    @Column(name = "attr1")
    private String attr1;

    @Column(name = "attr2")
    private String attr2;

    @Column(name = "attr3")
    private String attr3;

    @Column(name = "attr4")
    private String attr4;

    @Column(name = "attr5")
    private String attr5;

    public String getParamTypeName() {
        return paramTypeName;
    }

    public void setParamTypeName(String paramTypeName) {
        this.paramTypeName = paramTypeName;
    }

    public String getParamTypeCode() {
        return paramTypeCode;
    }

    public void setParamTypeCode(String paramTypeCode) {
        this.paramTypeCode = paramTypeCode;
    }

    public String getParamTypeDesc() {
        return paramTypeDesc;
    }

    public void setParamTypeDesc(String paramTypeDesc) {
        this.paramTypeDesc = paramTypeDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public ParameterType getParentParamType() {
        return parentParamType;
    }

    public void setParentParamType(ParameterType parentParamType) {
        this.parentParamType = parentParamType;
    }

    public List<ParameterType> getChildren() {
        return children;
    }

    public void setChildren(List<ParameterType> children) {
        this.children = children;
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
