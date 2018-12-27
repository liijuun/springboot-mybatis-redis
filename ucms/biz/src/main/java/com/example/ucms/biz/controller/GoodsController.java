package com.example.ucms.biz.controller;

import com.example.ucms.biz.entity.Goods;
import com.example.ucms.biz.service.GoodsService;
import com.example.ucms.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by j23li on 2018/12/27.
 */
@RestController
@RequestMapping(path = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(method = RequestMethod.POST)
    public Response addGoods(@Valid @RequestBody Goods goods){
        try{
            goodsService.addGoods(goods);
        } catch (RuntimeException e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }

        return new Response();

    }

    @RequestMapping(method = RequestMethod.GET)
    public Response<List<Goods>> getAllGoods(){
        List<Goods> goodsList;
        try{
            goodsList = goodsService.getAllGoods();
        } catch (RuntimeException e){
            return new Response<>(Response.R_CODE_NOTOK, e.getMessage());
        }
        Response<List<Goods>> response = new Response<>();
        response.setData(goodsList);
        return response;
    }
}
