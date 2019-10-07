package com.wangyanbao.qa.controller;/**
 * Created by ASUS on 2019/10/2.
 */

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

/**
*   @author   王彦宝
*   @description 公共异常处理类
*   @date 2019/10/218:58
*/
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
