package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.admin.domain.AgencyType;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业 (事务所)
 */
@Entity
@Table(name = "sys_agency")
public class Agency extends IEntity{
    /**
     *企业机构代码
     */
    @Column(name = "code")
    private String code;
    /**
     *企业名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 机构类型（服务商/客户）
     */
    @Column(name = "agencyType")
    private AgencyType agencyType;
    /**
     *所属国家
     */
    @Column(name = "country")
    private String country;
    /**
     *注册时间
     */
    @Column(name = "registerDate")
    private Date registerDate;
    /**
     *企业地址
     */
    @Column(name = "address")
    private String address;
    /**
     *邮编
     */
    @Column(name = "zipcode")
    private String zipcode;
    /**
     *负责人
     */
    @Column(name = "leader")
    private String leader;
    /**
     *邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     *联系电话
     */
    @Column(name = "cellphone")
    private String cellphone;
    /**
     *传真
     */
    @Column(name = "fax")
    private String fax;
    /**
     *网站名
     */
    @Column(name = "websiteName")
    private String websiteName;
    /**
     *网站logo
     */
    @Column(name = "websiteLogo")
    private String websiteLogo;
    /**
     *服务状态
     */
    @Column(name = "serverStatus")
    private String serverStatus;
    /**
     *服务起始时间
     */
    @Column(name = "serverEndDate")
    private Date serverStartDate;
    /**
     *服务结束时间
     */
    @Column(name = "serverEndDate")
    private Date serverEndDate;

    private List<AgencyCustomer> customers;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteLogo() {
        return websiteLogo;
    }

    public void setWebsiteLogo(String websiteLogo) {
        this.websiteLogo = websiteLogo;
    }

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    public Date getServerStartDate() {
        return serverStartDate;
    }

    public void setServerStartDate(Date serverStartDate) {
        this.serverStartDate = serverStartDate;
    }

    public Date getServerEndDate() {
        return serverEndDate;
    }

    public void setServerEndDate(Date serverEndDate) {
        this.serverEndDate = serverEndDate;
    }



}
