package com.wangyanbao.qa.controller;/**
 * Created by ASUS on 2019/10/4.
 */

import com.wangyanbao.qa.client.BaseClient;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
*   @author   王彦宝
*   @description 问答控制器
*   @date 2019/10/417:01
*/
@RestController
@CrossOrigin
@RequestMapping("/qa")
public class QaController {

    @Autowired
    private BaseClient baseClient;


    @RequestMapping(value = "/label/{labelId}",method = RequestMethod.GET)
    public Result findAById(@PathVariable("labelId") String labelId){
        Result result= baseClient.findAById(labelId);
        return result;
    }

}
