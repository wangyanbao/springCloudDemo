package com.wangyanbao.qa;/**
 * Created by ASUS on 2019/10/4.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.IdWorker;
import util.JwtUtil;

/**
*   @author   王彦宝
*   @description 问答启动
*   @date 2019/10/416:49
*/
@SpringBootApplication
@MapperScan("com.wangyanbao.qa.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return  new JwtUtil();
    }
}
