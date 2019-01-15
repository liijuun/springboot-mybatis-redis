package com.example.ucms.biz.controller;

import com.example.ucms.biz.entity.Goods;
import com.example.ucms.biz.service.GoodsService;
import com.example.ucms.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Response<Goods> getGoodsById(@PathVariable Integer id){
        Goods goods;
        try{
            goods = goodsService.getGoodsById(id);
        } catch (Exception e){
            return new Response<>(Response.R_CODE_NOTOK, e.getMessage());
        }
        Response<Goods> response = new Response<>();
        response.setData(goods);
        return response;
    }

    @RequestMapping(path = "/{id}/stock", method = RequestMethod.GET)
    public Response<Integer> getGoodsStock(@PathVariable Integer id){
          Goods goods;
          try{
              goods = goodsService.getGoodsById(id);
          } catch (Exception e){
              return new Response<>(Response.R_CODE_NOTOK, e.getMessage());
          }
          Response<Integer> response = new Response<>();
          response.setData(goods.getStock());
          return response;
    }

    @RequestMapping(path = "/{id}/stock", method = RequestMethod.PUT)
    public Response updateGoodsStock(@Valid @PathVariable Integer id, @RequestParam Integer stock){
        try{
            goodsService.updateGoodsStock(id, stock);
        } catch (Exception e){
            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();
    }


}
