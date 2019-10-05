package com.wangyanbao.sms;/**
 * Created by ASUS on 2019/10/5.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
*   @author   王彦宝
*   @description MQ启动类
*   @date 2019/10/59:19
*/
@SpringBootApplication
public class SmsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class,args);
    }
}
