package com.sunesoft.ecloud.adminclient;

/**
 * @Auther: niww
 * @Date: 2018/4/2/002
 */
public enum  UserPositionType {

    /**
     * 管理员
     */
    ADMIN("ADMIN","管理员"),
    /**
     * 组织架构负责人
     */
    LEADER("LEADER","组织架构负责人"),
    /**
     * 员工
     */
    EMPLOYEE("EMPLOYEE","员工");

    private String code;
    private String name;

    UserPositionType(String code, String name) {
        this.code = code;
        this.name = name;
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
}
