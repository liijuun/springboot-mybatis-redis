package com.example.ucms.biz.entity;

import com.example.ucms.common.entity.BaseEntity;

/**
 * Created by j23li on 2018/12/19.
 */
public class Role extends BaseEntity {

    private String name;
    private String code;
    private String description;
    private Integer wight;

    public Role() {
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

    public Integer getWight() {
        return wight;
    }

    public void setWight(Integer wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", wight=" + wight +
                '}';
    }
}
