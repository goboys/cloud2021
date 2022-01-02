package com.boys.springcloud.service;

import com.boys.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService
{
     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);

}
