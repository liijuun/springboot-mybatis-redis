package com.example.ucms.biz.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

@RestController
@RequestMapping("/secKillSimulation")
public class SecKillSimulationController {

    @RequestMapping(method = RequestMethod.GET)
    public void simulationCocurrentTakeOrder(){
        String secKillURI = "http://localhost/secKill";
        Integer goods_id = 1;
        Integer count = 5;
        final SimpleClientHttpRequestFactory httpRequestFactory  = new SimpleClientHttpRequestFactory();
        for(int i = 1; i <= 11; i++) {
            Integer finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ClientHttpRequest request = null;
                    try {
                        URI uri = new URI(String.format(
                                secKillURI + "?user_id=%s&goods_id=%s&count=%s", finalI, goods_id, count
                        ));
                        request = httpRequestFactory.createRequest(uri, HttpMethod.POST);
                        InputStream body = request.execute().getBody();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(body));
                        

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
