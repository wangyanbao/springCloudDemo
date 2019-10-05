package com.wangyanbao.user.controller;/**
 * Created by ASUS on 2019/10/2.
 */

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
*   @author   王彦宝
*   @description 公共异常处理类
*   @date 2019/10/218:58
*/
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
