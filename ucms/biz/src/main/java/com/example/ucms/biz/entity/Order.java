package com.example.ucms.biz.entity;

import com.example.ucms.common.entity.BaseEntity;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {


    private String orderId;

    @NotNull
    private Integer user_id;

    @NotNull
    private Integer goods_id;

    @NotNull
    private Integer count;

}
