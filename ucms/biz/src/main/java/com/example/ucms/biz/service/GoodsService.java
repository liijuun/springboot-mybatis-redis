package com.example.ucms.biz.service;

import com.example.ucms.biz.dao.GoodsMapper;
import com.example.ucms.biz.entity.Goods;
import com.example.ucms.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by j23li on 2018/12/27.
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    public void addGoods(Goods goods){
        if (null != goods.getId()){
            throw new ServiceException(
                    "Goods id is DB auto-increment, must null"
            );
        }

        goodsMapper.addGoods(goods);
    }

    public List<Goods> getAllGoods(){
        return goodsMapper.getAllGoods();
    }
}
