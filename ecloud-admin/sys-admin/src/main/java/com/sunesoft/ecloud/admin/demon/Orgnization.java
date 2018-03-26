package com.sunesoft.ecloud.admin.demon;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 * 组织机构
 */

@Entity
@Table(name="sys_orgnization")
public class Orgnization extends IEntity {

    /**
     * 组织机构名称
     */
    private String orgName;

    /**
     * 组织机构代码
     */
    private String orgCode;


    /**
     * 组织机构描述
     */
    private String orgDesc;


    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }
}
