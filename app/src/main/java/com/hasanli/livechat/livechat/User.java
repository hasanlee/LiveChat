package com.hasanli.livechat.livechat;

/**
 * Created by hasan on 10.05.2017.
 */

public class User {
    private String name;
    private String surname;
    private String phone;
    private String signdate;
    private String fullname;

    public User() {

    }

    public User(String name, String surname, String phone, String signdate, String fullname) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.signdate = signdate;
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSigndate() {
        return signdate;
    }

    public void setSigndate(String signdate) {
        this.signdate = signdate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
