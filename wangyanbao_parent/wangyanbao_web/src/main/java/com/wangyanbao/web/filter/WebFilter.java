package com.wangyanbao.web.filter;/**
 * Created by ASUS on 2019/10/6.
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
*   @author   王彦宝
*   @description 客户端网关过滤器
*   @date 2019/10/69:27
*/
@Component
public class WebFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("经过了后台过滤器");
        RequestContext requestContext=RequestContext.getCurrentContext();//获取request 上下文
        HttpServletRequest request=requestContext.getRequest();//得到request 域

        String authHeader= request.getHeader("Authorization");
        //String header = request.getHeader("Authorization");
        System.out.println("Authorization1:"+authHeader);
        if(request.getMethod().equals("OPTIONS")){
            return null;
        }
        if(request.getRequestURI().indexOf("login")>0){
            return null;
        }

        if(authHeader != null && !"".equals(authHeader)){
            if(authHeader.startsWith("Bearer ")){
                String token=authHeader.substring(7);
                System.out.println("token:"+token);
                try{
                    Claims claims=jwtUtil.parseJWT(token);
                    String role= (String) claims.get("roles");
                    System.out.println(role);
                    if(role.equals("user")){
                        requestContext.addZuulRequestHeader("Authorization",authHeader);
                        return null;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    requestContext.setSendZuulResponse(false);//终止运行
                }
            }

        }
        requestContext.setSendZuulResponse(false);//终止运行
        requestContext.setResponseStatusCode(403);
        requestContext.setResponseBody("权限不足");
        requestContext.getResponse().setContentType("text/html;charset=utf-8");
        return null;
    }
}
