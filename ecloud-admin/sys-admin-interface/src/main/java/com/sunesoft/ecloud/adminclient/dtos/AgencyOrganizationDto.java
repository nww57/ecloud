package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 * 机构信息
 */
public class AgencyOrganizationDto {

    private UUID id;

    /**
     * 所属企业id
     */
    private UUID agId;


    /**
     * 上层组织
     */
    private UUID parentId;

    /**
     * 上层组织名称
     */
    private String parentName;

    /**
     * 名称
     */
    private String name;
    /**
     *编码
     */
    private String code;

    /**
     *描述
     */
    private String description;



    /**
     * 负责人Id

     */
    private UUID leaderId;

    /**
     * 负责人
     */
    private String leaderName;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public UUID getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(UUID leaderId) {
        this.leaderId = leaderId;
    }
}
