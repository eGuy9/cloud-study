package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */

@EnableEurekaClient
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigCenter3344.class,args);
    }
}
