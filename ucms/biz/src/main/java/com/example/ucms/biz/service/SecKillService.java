package com.example.ucms.biz.service;

import com.example.ucms.biz.entity.Goods;
import com.example.ucms.biz.entity.Order;
import com.example.ucms.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class SecKillService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    public void secKill(Integer user_id, Integer goods_id, Integer count){
        System.out.println("Thread " + Thread.currentThread().getName() + " running");

        Goods goods = goodsService.getGoodsById(goods_id);
        if (null == goods){
            throw new ServiceException(
                    String.format("Goods(id=%s) not exist", goods_id)
            );
        }
        if (null == userService.getUserById(user_id)){
            throw new ServiceException(
                    String.format("User(id=%s) not exist", user_id)
            );
        }
        Integer stock = goods.getStock();
        System.out.println("Before order stock: " + stock);
        if (stock < count){
            throw new ServiceException(
                    String.format("Goods(id=%s) request %s, but only %s in stock",
                            goods_id, count, stock)
            );
        }

        Integer remained = stock - count;
        goodsService.updateGoodsStock(goods_id, remained);

        Order order = new Order();
        order.setUser_id(user_id);
        order.setGoods_id(goods_id);
        order.setCount(count);
        orderService.addOrder(order);

        System.out.println("After order stock:" + remained);
    }

}
