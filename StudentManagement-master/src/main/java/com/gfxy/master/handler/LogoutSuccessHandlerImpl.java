package com.gfxy.master.handler;

import com.alibaba.fastjson.JSON;
import com.gfxy.master.utils.JwtUtil;
import com.gfxy.master.utils.RedisCache;
import com.gfxy.master.utils.WebUtils;
import com.gfxy.master.vo.ResponseResult;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private RedisCache redisCache;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String token = request.getHeader("Authorization").substring(7);
        if (token != null) {
            try {
                Claims claims = JwtUtil.parseJWT(token);
                String userid = claims.getSubject();
                redisCache.deleteObject("login:" + userid);

                ResponseResult responseResult = new ResponseResult(HttpServletResponse.SC_OK, "注销成功");
                WebUtils.renderString(response, JSON.toJSONString(responseResult));
//            System.out.println(redisCache.deleteObject("login:" + claims.getSubject()) + "----成功");
            } catch (Exception e) {

                throw new RuntimeException(e);
            }
        }

    }

}
