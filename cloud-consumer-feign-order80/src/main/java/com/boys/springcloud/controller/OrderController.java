package com.boys.springcloud.controller;

import com.boys.springcloud.entities.CommonResult;
import com.boys.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
   private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/feign/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){

        CommonResult result =  paymentFeignService.getPaymentById(id);
        return result;
    }


    @GetMapping("/consumer/feign/payment/feign/timeout")
    public String paymentFeignTimeOut(){

        String result =  paymentFeignService.paymentFeignTimeOut();
        return result;
    }

}
