package com.boys.springcloud.controller;

import com.boys.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk/get")
    public CommonResult paymentInfo()
    {
       // String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk", String.class);
        CommonResult result =  restTemplate.getForObject(INVOKE_URL+"/payment/get/1",CommonResult.class);
        System.out.println("消费者调用支付服务(zookeeper)--->result:" + result);
        return result;
    }
}
