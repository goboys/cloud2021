package com.boys.springcloud;

import com.boys.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){

        CommonResult result =  restTemplate.getForObject(PaymentSrv_URL+"/payment/get/"+id,CommonResult.class,id);
        return result;
    }
}
