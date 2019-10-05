package com.wangyanbao.user.service;/**
 * Created by ASUS on 2019/10/5.
 */

import com.wangyanbao.user.mapper.AdminMapper;
import com.wangyanbao.user.mapper.UserMapper;
import com.wangyanbao.user.pojo.Admin;
import com.wangyanbao.user.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;

/**
*   @author   王彦宝
*   @description 管理员业务
*   @date 2019/10/511:06
*/
@Service
public class AdminService {


    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;


    public void add(Admin admin){
        admin.setId(idWorker.nextId()+"");
        admin.setPassword(encoder.encode(admin.getPassword()));
        adminMapper.insert(admin);
    }


    public Admin login(Admin admin){
        Admin dataAdmin=adminMapper.findByLoginname(admin.getLoginname());
        if(null!= dataAdmin && encoder.matches(admin.getPassword(),dataAdmin.getPassword())){
            return dataAdmin;
        }
        return null;
    }
}
