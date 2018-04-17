package com.sunesoft.ecloud.admin.domain.params;

import com.sunesoft.ecloud.hibernate.IEntity;

import java.util.List;

/**
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
public class ParameterType extends IEntity {


    private String parmTypeName;

    private String paramTypeCode;

    private String paramTypeDesc;

    private String remark;

    private List<ParameterType> parameterTypeList;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;
}
