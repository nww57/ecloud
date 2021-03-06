package com.sunesoft.ecloud.admin.domain.agency;


import com.sunesoft.ecloud.adminclient.AgencyType;
import com.sunesoft.ecloud.adminclient.ServerStatusType;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
     * 代理机构代码（国知局给的）
     */
    @Column(name = "agencyCode")
    private String agencyCode;

    /**
     *企业名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 机构类型（服务商/客户）
     */
    @Column(name = "agencyType")
    @Enumerated(EnumType.STRING)
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
    private LocalDate registerDate;

    /**
     * 地区code
     */
    @Column(name = "addressCode")
    private String addressCode;
    /**
     * 省
     */
    @Column(name = "province")
    private String province;
    /**
     *市
     */
    @Column(name = "city")
    private String city;
    /**
     *区
     */
    @Column(name = "district")
    private String district;
    /**
     *街道
     */
    @Column(name = "street")
    private String street;

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
    @Enumerated(EnumType.STRING)
    private ServerStatusType serverStatus;
    /**
     *服务起始时间
     */
    @Column(name = "serverStartDate")
    private LocalDateTime serverStartDate;
    /**
     *服务结束时间
     */
    @Column(name = "serverEndDate")
    private LocalDateTime serverEndDate;

    @OneToMany(mappedBy = "agency")
    private List<AgencyCustomer> customers = new ArrayList<>();


    public Agency() {
        this.agencyType = AgencyType.ServiceAgency;
        this.serverStatus = ServerStatusType.ENABLE;
    }

    public Agency(AgencyType agencyType) {
        this.agencyType = agencyType;
        this.serverStatus = ServerStatusType.ENABLE;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

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


    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
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

    public ServerStatusType getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(ServerStatusType serverStatus) {
        this.serverStatus = serverStatus;
    }

    public LocalDateTime getServerStartDate() {
        return serverStartDate;
    }

    public void setServerStartDate(LocalDateTime serverStartDate) {
        this.serverStartDate = serverStartDate;
    }

    public LocalDateTime getServerEndDate() {
        return serverEndDate;
    }

    public void setServerEndDate(LocalDateTime serverEndDate) {
        this.serverEndDate = serverEndDate;
    }

    public AgencyType getAgencyType() {
        return agencyType;
    }

    public void setAgencyType(AgencyType agencyType) {
        this.agencyType = agencyType;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<AgencyCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<AgencyCustomer> customers) {
        this.customers = customers;
    }


}
