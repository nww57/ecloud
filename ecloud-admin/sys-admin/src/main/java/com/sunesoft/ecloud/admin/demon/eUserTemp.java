package com.sunesoft.ecloud.admin.demon;

import com.sunesoft.ecloud.hibernate.IEntity;

import java.util.Date;

/**
 * @author: Zhouzh
 * @Date: 2018/3/21
 */
public class eUserTemp extends IEntity {


    private String userName;

    private String password;

    private String sex;
    private String sex2;


    private Date datea;


    private Test1 test1;

    private Test1 test2;

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

    public String getSex2() {
        return sex2;
    }

    public void setSex2(String sex2) {
        this.sex2 = sex2;
    }

    public Test1 getTest2() {
        return test2;
    }

    public void setTest2(Test1 test2) {
        this.test2 = test2;
    }
}
