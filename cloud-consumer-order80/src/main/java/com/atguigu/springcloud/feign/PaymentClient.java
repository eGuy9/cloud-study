package com.atguigu.springcloud.feign;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-payment-service",fallback = PaymentFallback.class)
public interface PaymentClient {

    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/create")
    CommonResult create(Payment payment);

    @GetMapping("/payment/test1/{id}")
    String test1(@PathVariable("id") Long id);

    @GetMapping("/payment/test2/{id}")
    String test2(@PathVariable("id") Long id);


}
