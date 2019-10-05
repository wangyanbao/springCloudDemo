package com.wangyanbao.user.controller;/**
 * Created by ASUS on 2019/10/5.
 */

import com.wangyanbao.user.pojo.Admin;
import com.wangyanbao.user.service.AdminService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
*   @author   王彦宝
*   @description 管理员控制器
*   @date 2019/10/511:03
*/
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtUtil jwtUtil;


    @RequestMapping(method = RequestMethod.POST)
    public Result addAdmin(@RequestBody Admin admin){
        adminService.add(admin);
        return new Result(true, StatusCode.OK,"添加成功");
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Admin admin){
        Admin loginadmin=adminService.login(admin);
        if(loginadmin ==null){
            return new Result(false, StatusCode.LOGINERROR,"登陆失败");
        }
        String token=jwtUtil.createJWT(loginadmin.getId(),loginadmin.getLoginname(),"admin");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("token",token);
        map.put("role","admin");
        return new Result(true, StatusCode.OK,"登陆成功",map);
    }

}
