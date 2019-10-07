package com.wangyanbao.manager.filter;/**
 * Created by ASUS on 2019/10/6.
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
*   @author   王彦宝
*   @description 后台网关过滤器
*   @date 2019/10/69:13
*/
@Component
public class ManagerFilter extends ZuulFilter {
    /**
     * 在请求前 pre 或请求后执行 post
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 多个过滤器的执行顺序，数字越小，越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否开启  true 开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行的操作 return 任何object 的值都表示继续执行
     * setsendzullRespponse(false) 表示不再继续执行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过了后台过滤器");
        return null;
    }
}
