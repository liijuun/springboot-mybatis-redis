package com.example.ucms.biz.controller;

import com.example.ucms.biz.service.SecKillService;
import com.example.ucms.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/secKill")
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    @RequestMapping(method = RequestMethod.POST)
    public Response secKill(@RequestParam Integer user_id, @RequestParam Integer goods_id, @RequestParam Integer count){
        try{
            secKillService.secKill(user_id, goods_id, count);
        } catch (Exception e){

            return new Response(Response.R_CODE_NOTOK, e.getMessage());
        }
        return new Response();
    }
}
