package com.boys.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.boys.springcloud.service.FlowLimitService;
import org.springframework.stereotype.Service;

@Service
public class FlowLimitServiceImpl implements FlowLimitService {

    @Override
    @SentinelResource("getStr")
    public String getStr() {
        return "hello !";
    }

}
