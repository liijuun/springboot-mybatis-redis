package com.example.ucms.biz.entity;

import com.example.ucms.common.entity.BaseEntity;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by j23li on 2018/12/19.
 */
public class Role extends BaseEntity {

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    private String code;

    private String description;

    @NotNull
    private Integer wight;
    public Role(){

    };

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
