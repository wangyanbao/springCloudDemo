package com.wangyanbao.config;/**
 * Created by ASUS on 2019/10/6.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
*   @author   王彦宝
*   @description 配置中心启动
*   @date 2019/10/613:40
*/
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
