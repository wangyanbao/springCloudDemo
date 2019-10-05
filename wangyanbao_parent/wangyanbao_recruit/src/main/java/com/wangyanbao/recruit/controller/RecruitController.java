package com.wangyanbao.recruit.controller;/**
 * Created by ASUS on 2019/10/4.
 */

import com.github.pagehelper.Page;
import com.wangyanbao.recruit.pojo.Recruit;
import com.wangyanbao.recruit.service.RecruitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
*   @author   王彦宝
*   @description 招聘控制器
*   @date 2019/10/416:34
*/
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",recruitService.findAll());
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}",method = RequestMethod.GET)
    public Result findByPage(@PathVariable int pageNo, @PathVariable int pageSize){
        Page page=recruitService.findByPage(pageNo,pageSize);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Recruit>(page.getTotal(),page.getResult()));
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findAById(@PathVariable String labelId){

        return new Result(true, StatusCode.OK,"查询成功",recruitService.findAById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Recruit label){
        recruitService.save(label);
        return new Result(true, StatusCode.OK,"添加成功");
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId,@RequestBody Recruit label){
        return new Result(true, StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteAById(@PathVariable("labelId") String labelId){
        recruitService.deleteAById(labelId);
        return new Result(true, StatusCode.OK,"删除成功");
    }
}
