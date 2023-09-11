package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

    public String test1(@Param("id") Long id);
    public String test2(@Param("id") Long id);

    public String breaker(@Param("id") Long id);
}
