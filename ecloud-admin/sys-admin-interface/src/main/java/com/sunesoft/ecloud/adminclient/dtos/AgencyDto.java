package com.sunesoft.ecloud.adminclient.dtos;


import com.sunesoft.ecloud.adminclient.AgencyType;
import com.sunesoft.ecloud.adminclient.ServerStatusType;

import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class AgencyDto {

    private UUID id;

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
    private String registerDate;
    /**
     * 地区code
     */
    private String addressCode;
    /**
     * 省
     */
    private String province;
    /**
     *市
     */
    private String city;
    /**
     *区
     */
    private String district;
    /**
     *街道
     */
    private String street;
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
    private ServerStatusType serverStatus;
    /**
     *服务起始时间
     */
    private String serverStartDate;
    /**
     *服务结束时间
     */
    private String serverEndDate;

    private List<UUID> menuIds;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public AgencyType getAgencyType() {
        return agencyType;
    }

    public void setAgencyType(AgencyType agencyType) {
        this.agencyType = agencyType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
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

    public String getServerStartDate() {
        return serverStartDate;
    }

    public void setServerStartDate(String serverStartDate) {
        this.serverStartDate = serverStartDate;
    }

    public String getServerEndDate() {
        return serverEndDate;
    }

    public void setServerEndDate(String serverEndDate) {
        this.serverEndDate = serverEndDate;
    }

    public List<UUID> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<UUID> menuIds) {
        this.menuIds = menuIds;
    }



}
