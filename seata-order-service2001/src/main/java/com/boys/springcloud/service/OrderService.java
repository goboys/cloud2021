package com.boys.springcloud.service;

import com.boys.springcloud.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
