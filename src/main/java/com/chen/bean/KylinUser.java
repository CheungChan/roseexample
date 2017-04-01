package com.chen.bean;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/1.
 */
public class KylinUser {
    private int id;
    private String accountName;
    private String phone;
    private String pwd;
    private Timestamp regTime;
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "KylinUser{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", regTime=" + regTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
