package com.sunesoft.ecloud.admin.demon;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Zhouzh
 * @Date: 2018/3/21
 */
@Entity
@Table(name = "e_user")
public class EUser extends IEntity {

    private String userName;

    private String password;

    private String sex;


    private Date datea;


    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Test1 test1;


    public Test1 getTest1() {
        return test1;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    public Date getDatea() {
        return datea;
    }

    public void setDatea(Date datea) {
        this.datea = datea;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
