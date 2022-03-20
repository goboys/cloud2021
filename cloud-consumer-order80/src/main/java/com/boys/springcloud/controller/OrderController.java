package com.boys.springcloud.controller;

import com.boys.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    public static final String PaymentSrv_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){

        CommonResult result =  restTemplate.getForObject(PaymentSrv_URL+"/payment/get/"+id,CommonResult.class,id);

        return result;
    }
}
