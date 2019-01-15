package com.example.ucms.biz.service;

import com.example.ucms.biz.dao.OrderMapper;
import com.example.ucms.biz.entity.Order;
import com.example.ucms.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;


    private synchronized String generateOrderId(Integer uid) {
        String id = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        return id + uid.toString();
    }

    public void addOrder(Order order){
        if (null != order.getId()){
            throw new ServiceException(
                    "Order id is DB auto-increment, must null"
            );
        }

        if (null != order.getOrderId()){
            throw new ServiceException(
                    "Order orderId is auto-generated, must null"
            );
        }

        order.setOrderId(generateOrderId(order.getUser_id()));
        System.out.println(order.getOrderId());

        if (null != orderMapper.getOrderByOrderId(order.getOrderId())){
            throw new ServiceException(
                    String.format("Order(orderId=%s) already exist", order.getOrderId())
            );
        }
        orderMapper.addOrder(order);
    }

    public List<Order> getAllOrders(){
        return orderMapper.getAllOrders();
    }

    public Order getOrderByOrderId(String orderId){
        return orderMapper.getOrderByOrderId(orderId);
    }
}
