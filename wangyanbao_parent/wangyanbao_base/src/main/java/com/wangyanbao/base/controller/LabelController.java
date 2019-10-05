package com.wangyanbao.base.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wangyanbao.base.pojo.Label;
import com.wangyanbao.base.service.ILabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
*   @author   王彦宝
*   @description 基础控制类
*   @date 2019/10/212:04
*/
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private ILabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}",method = RequestMethod.GET)
    public Result findByPage(@PathVariable int pageNo, @PathVariable int pageSize){
        Page page=labelService.findByPage(pageNo,pageSize);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Label>(page.getTotal(),page.getResult()));
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findAById(@PathVariable String labelId){

        return new Result(true, StatusCode.OK,"查询成功",labelService.findAById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,"添加成功");
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId,@RequestBody Label label){
        return new Result(true, StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteAById(@PathVariable("labelId") String labelId){
        labelService.deleteAById(labelId);
        return new Result(true, StatusCode.OK,"删除成功");
    }
}
