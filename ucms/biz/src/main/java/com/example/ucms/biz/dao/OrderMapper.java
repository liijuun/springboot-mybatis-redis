package com.example.ucms.biz.dao;

import com.example.ucms.biz.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {


    @Insert("INSERT INTO sys_order (order_id, user_id, goods_id, count) " +
            "VALUES(#{orderId}, #{user_id}, #{goods_id}, #{count})")
    void addOrder(Order order);

    @Select("SELECT * from sys_order")
    @Results ({
        @Result(property = "orderId", column = "order_id")
    })
    List<Order> getAllOrders();

    @Select("SELECT * from sys_order where order_id = #{orderId}")
    Order getOrderByOrderId(String orderId);
}
