package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.ServerStatusType;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
public class AgencyBasicDto {

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

    public String getServerEndDate() {
        return serverEndDate;
    }

    public void setServerEndDate(String serverEndDate) {
        this.serverEndDate = serverEndDate;
    }


    public String getServerStartDate() {
        return serverStartDate;
    }

    public void setServerStartDate(String serverStartDate) {
        this.serverStartDate = serverStartDate;
    }
}
