package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
* 描述：eureka 是spring cloud 服务注册中心 
* 		要注册服务需要先启动服务注册中心
* @author chuan
* @since 1.0
* @date 2020年1月10日
*/
@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurekaApplication {
    public static void main( String[] args ){
    	SpringApplication.run(MicroserviceEurekaApplication.class, args);
    	
    }
}
