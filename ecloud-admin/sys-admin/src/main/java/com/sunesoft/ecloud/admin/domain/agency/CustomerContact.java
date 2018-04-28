package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户联系人维护
 */
@Entity
@Table(name = "customer_contacts")
public class CustomerContact extends IEntity {

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 联系方式
     */
    @Column(name = "cellphone")
    private String cellphone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * QQ
     */
    @Column(name = "qq")
    private String qq;


    /**
     * 所属客户
     */
    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
