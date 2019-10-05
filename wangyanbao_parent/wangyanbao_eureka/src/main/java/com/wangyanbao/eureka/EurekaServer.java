package com.wangyanbao.eureka;/**
 * Created by ASUS on 2019/10/5.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
*   @author   王彦宝
*   @description eureka
*   @date 2019/10/517:17
*/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class);
    }
}
