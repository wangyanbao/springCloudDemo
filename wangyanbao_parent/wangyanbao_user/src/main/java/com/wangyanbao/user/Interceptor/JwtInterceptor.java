package com.wangyanbao.user.Interceptor;/**
 * Created by ASUS on 2019/10/5.
 */

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*   @author   王彦宝
*   @description 拦截器
*   @date 2019/10/514:47
*/
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        //拦截器对token 做一个解析验证
        String header = request.getHeader("Authorization");
        System.out.println(header);

        if(header != null && !"".equals(header)){
            //有头信息 解析
            if(header.startsWith("Bearer ")){
                String token=header.substring(7);
                try{
                    Claims claims=jwtUtil.parseJWT(token);
                    String role= (String) claims.get("role");
                    if(role == null|| role.equals("admin")){
                        request.setAttribute("claims_admin",token);
                    }
                    if(role == null|| role.equals("user")){
                        request.setAttribute("claims_user",token);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确！");
                }
            }
        }
        return true;
    }
}
