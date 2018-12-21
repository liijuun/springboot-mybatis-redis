package com.example.ucms.biz.entity;

import com.example.ucms.common.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by j23li on 2018/12/16.
 */
public class User extends BaseEntity {

    @NotNull
    private String uid;

    @NotNull
    private String name;

    @NotNull
    private String password;

    private String gender;


    public User() {

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
