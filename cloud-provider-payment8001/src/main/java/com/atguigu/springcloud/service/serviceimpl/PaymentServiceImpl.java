package com.atguigu.springcloud.service.serviceimpl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//@DefaultProperties(defaultFallback = "test2Handler")  //全局默认fallback
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }


    @HystrixCommand    //未设置指定fallback，使用全局默认fallback
    public String test1(Long id){
        return "线程池： " +Thread.currentThread().getName() +" paymentid: " +id+ "通过";
    }

    //设置服务降级策略
    @HystrixCommand(fallbackMethod = "test2Handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String test2(Long id){
        int i = 10/0;
        return "线程池： " +Thread.currentThread().getName() +" paymentid: " +id+ "未通过";
    }


    @Override
    @HystrixCommand(fallbackMethod = "test2Handler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String breaker(Long id) {
        if(id > 1){
            int i = 10/0;
        }

        return "线程池： " +Thread.currentThread().getName() +" paymentid: " +id+ "通过";
    }
    public String test2Handler(Long id){

        return "线程池： " +Thread.currentThread().getName() +" paymentid: " +id+ "未通过";
    }


}
