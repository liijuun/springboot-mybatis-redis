package com.example.ucms.common.entity;

import java.io.Serializable;

/**
 * Created by j23li on 2018/12/16.
 */
public class BaseEntity implements Serializable {

    private Integer id;

    public BaseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
