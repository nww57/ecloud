package com.sunesoft.ecloud.admin.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 */
@Entity
@Table(name = "sys_company", schema = "ecloud", catalog = "")
public class SysCompanyEntity {
    private String id;
    private String code;
    private String name;
    private String country;
    private Date regisitDatetime;
    private String address;
    private String zipcode;
    private String leader;
    private String email;
    private String cellphone;
    private String fax;
    private String websiteName;
    private String websiteLogo;
    private Integer serverStatus;
    private Date serverStartdate;
    private Date serverEnddate;
    private Timestamp createDatetime;
    private String createBy;
    private Timestamp lastModifyDatetime;
    private String lastModifyBy;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
    @Column(name = "regisitDatetime")
    public Date getRegisitDatetime() {
        return regisitDatetime;
    }

    public void setRegisitDatetime(Date regisitDatetime) {
        this.regisitDatetime = regisitDatetime;
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
    public Integer getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(Integer serverStatus) {
        this.serverStatus = serverStatus;
    }

    @Basic
    @Column(name = "serverStartdate")
    public Date getServerStartdate() {
        return serverStartdate;
    }

    public void setServerStartdate(Date serverStartdate) {
        this.serverStartdate = serverStartdate;
    }

    @Basic
    @Column(name = "serverEnddate")
    public Date getServerEnddate() {
        return serverEnddate;
    }

    public void setServerEnddate(Date serverEnddate) {
        this.serverEnddate = serverEnddate;
    }

    @Basic
    @Column(name = "createDatetime")
    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Basic
    @Column(name = "createBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "lastModifyDatetime")
    public Timestamp getLastModifyDatetime() {
        return lastModifyDatetime;
    }

    public void setLastModifyDatetime(Timestamp lastModifyDatetime) {
        this.lastModifyDatetime = lastModifyDatetime;
    }

    @Basic
    @Column(name = "lastModifyBy")
    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysCompanyEntity that = (SysCompanyEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country) &&
                Objects.equals(regisitDatetime, that.regisitDatetime) &&
                Objects.equals(address, that.address) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(leader, that.leader) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cellphone, that.cellphone) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(websiteName, that.websiteName) &&
                Objects.equals(websiteLogo, that.websiteLogo) &&
                Objects.equals(serverStatus, that.serverStatus) &&
                Objects.equals(serverStartdate, that.serverStartdate) &&
                Objects.equals(serverEnddate, that.serverEnddate) &&
                Objects.equals(createDatetime, that.createDatetime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(lastModifyDatetime, that.lastModifyDatetime) &&
                Objects.equals(lastModifyBy, that.lastModifyBy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, code, name, country, regisitDatetime, address, zipcode, leader, email, cellphone, fax, websiteName, websiteLogo, serverStatus, serverStartdate, serverEnddate, createDatetime, createBy, lastModifyDatetime, lastModifyBy);
    }
}
