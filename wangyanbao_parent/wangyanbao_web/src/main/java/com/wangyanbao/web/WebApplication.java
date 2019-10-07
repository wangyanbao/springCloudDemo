package com.wangyanbao.web;/**
 * Created by ASUS on 2019/10/6.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
*   @author   王彦宝
*   @description 前端网关
*   @date 2019/10/69:06
*/

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
