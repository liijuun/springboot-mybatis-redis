package com.example.ucms.biz.entity;

import com.example.ucms.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by j23li on 2018/12/27.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Goods extends BaseEntity {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Integer stock;
}
