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
    private String code;
    /**
     *企业名称
     */
    private String name;


    /**
     * 机构类型（服务商/客户）
     */
    private AgencyType agencyType;
    /**
     *所属国家
     */
    private String country;
    /**
     *注册时间
     */
    private Date registerDate;
    /**
     *企业地址
     */
    private String address;
    /**
     *邮编
     */
    private String zipcode;
    /**
     *负责人
     */
    private String leader;
    /**
     *邮箱
     */
    private String email;
    /**
     *联系电话
     */
    private String cellphone;
    /**
     *传真
     */
    private String fax;
    /**
     *网站名
     */
    private String websiteName;
    /**
     *网站logo
     */
    private String websiteLogo;
    /**
     *服务状态
     */
    private String serverStatus;
    /**
     *服务起始时间
     */
    private Date serverStartDate;
    /**
     *服务结束时间
     */
    private Date serverEndDate;

    private List<AgencyCustomer> customers;

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "registerDate")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "leader")
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "cellphone")
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "websiteName")
    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    @Basic
    @Column(name = "websiteLogo")
    public String getWebsiteLogo() {
        return websiteLogo;
    }

    public void setWebsiteLogo(String websiteLogo) {
        this.websiteLogo = websiteLogo;
    }

    @Basic
    @Column(name = "serverStatus")
    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    @Basic
    @Column(name = "serverStartDate")
    public Date getServerStartDate() {
        return serverStartDate;
    }

    public void setServerStartDate(Date serverStartDate) {
        this.serverStartDate = serverStartDate;
    }

    @Basic
    @Column(name = "serverEndDate")
    public Date getServerEndDate() {
        return serverEndDate;
    }

    public void setServerEndDate(Date serverEndDate) {
        this.serverEndDate = serverEndDate;
    }



}
