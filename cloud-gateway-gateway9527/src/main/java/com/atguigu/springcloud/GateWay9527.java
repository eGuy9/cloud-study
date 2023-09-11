package com.atguigu.springcloud;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWay9527
{
    public static void main( String[] args )
    {
        SpringApplication.run(GateWay9527.class,args);
    }
}
