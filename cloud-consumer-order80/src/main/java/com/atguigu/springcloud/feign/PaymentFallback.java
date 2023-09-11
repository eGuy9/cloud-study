package com.atguigu.springcloud.feign;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

public class PaymentFallback implements PaymentClient{
    @Override
    public CommonResult getPaymentById(Long id) {
        return null;
    }

    @Override
    public CommonResult create(Payment payment) {
        return null;
    }

    @Override
    public String test1(Long id) {
        return "线程池： " +Thread.currentThread().getName() +" paymentid: " +id+ "未通过";
    }

    @Override
    public String test2(Long id) {
        return "线程池： " +Thread.currentThread().getName() +" paymentid: " +id+ "未通过";
    }
}
