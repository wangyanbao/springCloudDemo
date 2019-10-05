package com.wangyanbao.user.config;/**
 * Created by ASUS on 2019/10/5.
 */

import com.wangyanbao.user.Interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
*   @author   王彦宝
*   @description 过滤器
*   @date 2019/10/514:50
*/
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    protected void addInterceptors(InterceptorRegistry registry) {

        //拦截对象和要拦截的请求

        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("*/login/**");
    }
}
