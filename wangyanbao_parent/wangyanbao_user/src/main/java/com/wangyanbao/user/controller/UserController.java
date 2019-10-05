package com.wangyanbao.user.controller;/**
 * Created by ASUS on 2019/10/4.
 */

import com.wangyanbao.user.pojo.Admin;
import com.wangyanbao.user.pojo.User;
import com.wangyanbao.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
*   @author   王彦宝
*   @description 用户控制器
*   @date 2019/10/422:44
*/
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/sendSms/{mobile}",method = RequestMethod.GET)
    public Result sendSms(@PathVariable String mobile){
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK,"发送成功");
    }

    @RequestMapping(value = "/register/{code}",method = RequestMethod.POST)
    public Result regist(@PathVariable String code,@RequestBody User user){

        String redisCode= (String) redisTemplate.opsForValue().get("checkCode_"+user.getMobile());

        if(redisCode.isEmpty()){
            return new Result(false, StatusCode.ERROR,"请获取验证码");
        }
        if(!redisCode.equals(code)){
            return new Result(false, StatusCode.ERROR,"验证码输入不正确");
        }
        userService.add(user);
        return new Result(true, StatusCode.OK,"发送成功");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody User user){

        User loginadmin=userService.login(user);
        if(loginadmin ==null){
            return new Result(false, StatusCode.LOGINERROR,"登陆失败");
        }
        String token=jwtUtil.createJWT(loginadmin.getId(),loginadmin.getNickname(),"user");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("token",token);
        map.put("role","user");
        return new Result(true, StatusCode.OK,"登陆成功",map);
    }
}
