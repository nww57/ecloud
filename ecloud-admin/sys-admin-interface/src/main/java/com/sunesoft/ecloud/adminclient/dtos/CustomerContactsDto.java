package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户联系人操作dto
 */
public class CustomerContactsDto {

    private UUID id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * QQ
     */
    private String qq;

    /**
     * 座机
     */
    private String phone;

    /**
     * 所属客户
     */
    private UUID customerId;
}
