package com.wangyanbao.manager;/**
 * Created by ASUS on 2019/10/6.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
*   @author   王彦宝
*   @description 后台网关
*   @date 2019/10/68:54
*/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class,args);
    }
}
