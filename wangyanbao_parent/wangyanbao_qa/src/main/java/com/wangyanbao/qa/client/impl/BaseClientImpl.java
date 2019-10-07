package com.wangyanbao.qa.client.impl;/**
 * Created by ASUS on 2019/10/6.
 */

import com.wangyanbao.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
*   @author   王彦宝
*   @description 熔断器
*   @date 2019/10/68:31
*/
@Component
public class BaseClientImpl implements BaseClient{

    @Override
    public Result findAById(String labelId) {
        System.out.println("熔断器触发了");
        return new Result(false, StatusCode.ERROR,"熔断器触发了");
    }
}
