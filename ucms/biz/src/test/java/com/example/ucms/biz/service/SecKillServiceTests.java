package com.example.ucms.biz.service;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.net.URI;

public class SecKillServiceTests {

    @Test
    public void secKillTest(){
        String secKillURI = "http://localhost/secKill";
        Integer goods_id = 1;
        Integer count = 1;
        final SimpleClientHttpRequestFactory httpRequestFactory  = new SimpleClientHttpRequestFactory();
        for(int i = 1; i <= 11; i++){
            Integer finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ClientHttpRequest request = null;
                    try{
                        URI uri = new URI(String.format(
                                secKillURI + "?user_id=%s&goods_id=%s&count=%s", finalI, goods_id, count
                        ));
                        request = httpRequestFactory.createRequest(uri, HttpMethod.POST);

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}
