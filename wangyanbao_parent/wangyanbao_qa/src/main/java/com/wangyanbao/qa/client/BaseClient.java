package com.wangyanbao.qa.client;/**
 * Created by ASUS on 2019/10/5.
 */

import com.wangyanbao.qa.client.impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
*   @author   王彦宝
*   @description feign
*   @date 2019/10/521:46
*/
@FeignClient(value="wangyanbao-base",fallback = BaseClientImpl.class)
public interface BaseClient {

    @RequestMapping(value = "/label/{labelId}",method = RequestMethod.GET)
    public Result findAById(@PathVariable("labelId") String labelId);
}
