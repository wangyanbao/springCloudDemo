package com.wangyanbao.sms.listener;/**
 * Created by ASUS on 2019/10/5.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
*   @author   王彦宝
*   @description 短信监听器
*   @date 2019/10/59:21
*/
@Component
@RabbitListener(queues = "sms")
public class SmsListener {


    @RabbitHandler
    public  void executeSms(Map<String,String> map){
        System.out.println("手机号："+map.get("mobile"));
        System.out.println("验证码："+map.get("checkCode"));

    }
}
