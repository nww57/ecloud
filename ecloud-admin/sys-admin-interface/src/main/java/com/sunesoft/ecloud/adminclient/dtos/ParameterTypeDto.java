package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.common.TreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:12
 * -
 */
public class ParameterTypeDto extends TreeEntity {

    /**
     * 参数类型名
     */
    private String paramTypeName;

    /**
     *参数类型编码
     */
    private String paramTypeCode;

    /**
     *参数类型描述
     */
    private String paramTypeDesc;

    /**
     * 备注
     */
    private String remark;

    /**
     *参数类型关联参数
     */
    private List<ParameterDto> parameterList;

    /**
     *参数类型父节点
     */
    private ParameterTypeDto parentParamType;

    /**
     *参数类型子节点
     */
    private List<ParameterTypeDto> children = new ArrayList<>();

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

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

    public List<ParameterDto> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<ParameterDto> parameterList) {
        this.parameterList = parameterList;
    }

    public ParameterTypeDto getParentParamType() {
        return parentParamType;
    }

    public void setParentParamType(ParameterTypeDto parentParamType) {
        this.parentParamType = parentParamType;
    }

    public List<ParameterTypeDto> getChildren() {
        return children;
    }

    public void setChildren(List children) {
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
