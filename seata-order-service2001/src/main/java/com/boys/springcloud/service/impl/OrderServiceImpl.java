package com.boys.springcloud.service.impl;



import com.boys.springcloud.dao.OrderDao;
import com.boys.springcloud.domain.Order;
import com.boys.springcloud.service.AccountService;
import com.boys.springcloud.service.OrderService;
import com.boys.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2019-12-11 16:50
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService
{
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：
     * 下订单->减库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        try {
            log.info("------->下单开始");
            //本应用创建订单
            orderDao.create(order);

            //远程调用库存服务扣减库存
            log.info("------->order-service中扣减库存开始");
            storageService.decrease(order.getProductId(), order.getCount());
            log.info("------->order-service中扣减库存结束");

            //远程调用账户服务扣减余额
            log.info("------->order-service中扣减余额开始");
            accountService.decrease(order.getUserId(), order.getMoney());
            log.info("------->order-service中扣减余额结束");

            //修改订单状态为已完成
            log.info("------->order-service中修改订单状态开始");
            orderDao.update(order.getUserId(), 0);
            log.info("------->order-service中修改订单状态结束");

            log.info("------->下单结束");
        }catch (Exception e){
            log.error("系统异常",e);
        }
    }
}
