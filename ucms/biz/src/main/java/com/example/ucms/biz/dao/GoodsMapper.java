package com.example.ucms.biz.dao;

import com.example.ucms.biz.entity.Goods;
import org.apache.ibatis.annotations.*;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by j23li on 2018/12/27.
 */
@Mapper
public interface GoodsMapper {

    @Select("SELECT * from sys_goods")
    List<Goods> getAllGoods();

    @Insert("INSERT INTO sys_goods (name, description, price, stock) " +
            "VALUES(#{name}, #{description}, #{price}, #{stock})")
    void addGoods(Goods goods);

    @Select("SELECT * from sys_goods WHERE id = #{id} for update")
    Goods getGoodsById(Integer id);

    @Update("UPDATE sys_goods SET stock=#{stock} WHERE id=#{id}")
    void updateGoodsStock(Integer id, Integer stock);




}
