package com.wangyanbao.user.service;/**
 * Created by ASUS on 2019/10/4.
 */

import com.wangyanbao.user.mapper.UserMapper;
import com.wangyanbao.user.pojo.Admin;
import com.wangyanbao.user.pojo.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
*   @author   王彦宝
*   @description 用户业务
*   @date 2019/10/422:45
*/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate  rabbitTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;


    public void sendSms(String mobile){

        String random=RandomStringUtils.randomNumeric(6);

        redisTemplate.opsForValue().set("checkCode_"+mobile,random,6, TimeUnit.MINUTES);

        Map<String,String> map = new HashMap<String,String>();

        map.put("mobile",mobile);
        map.put("checkCode",random);
        rabbitTemplate.convertAndSend("sms",map);
        System.out.println("验证码生产完成"+random);
    }

    public void add(User user){
        user.setId(idWorker.nextId()+"");
        user.setPassword(encoder.encode(user.getPassword()));
        user.setFollowcount(0);//关注数        
        user.setFanscount(0);//粉丝数        
        user.setOnline(0);//在线时长        
        user.setRegdate(new Date());//注册日期        
        user.setUpdatedate(new Date());//更新日期        
        user.setLastdate(new Date());//最后登陆日期
        userMapper.insert(user);
    }


    public User login(User user){
        User dataUser=userMapper.findBynickname(user.getNickname());
        if(null!= dataUser && encoder.matches(user.getPassword(),dataUser.getPassword())){
            return dataUser;
        }
        return null;
    }

}
