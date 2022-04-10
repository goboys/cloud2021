package com.boys.springcloud.dao;

import com.boys.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper//推荐使用mapper，用@Reoisutirt注解可能出现注入问题
public interface  PaymentDao {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);

}
