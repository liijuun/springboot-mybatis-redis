package com.example.ucms.biz.controller;

import com.example.ucms.biz.entity.Order;
import com.example.ucms.biz.service.OrderService;
import com.example.ucms.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Response addOrder(Order order){
        try{
            orderService.addOrder(order);
        } catch (Exception e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Response<List<Order>> getAllOrders(){
        List<Order> orders;
        try{
            orders = orderService.getAllOrders();
        } catch (Exception e){
            return new Response<>(Response.R_CODE_NOTOK, e.getMessage());
        }
        Response<List<Order>> response = new Response<>();
        response.setData(orders);
        return response;
    }
}
