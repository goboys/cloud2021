package com.boys.springcloud.controller;


import com.boys.springcloud.service.FlowLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FlowLimitController {

    @Autowired
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA()
    {

        return flowLimitService.getStr();
    }

    @GetMapping("/testB")
    public String testB()
    {

        return flowLimitService.getStr();
    }
}
