package com.gfxy.master.service.impl;

import com.gfxy.master.service.LoginService;
import com.gfxy.master.utils.JwtUtil;
import com.gfxy.master.utils.RedisCache;
import com.gfxy.master.vo.LoginUser;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        // AuthenticationManager 的 authenticate 方法进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }

        // 如果认证通过，使用 userid 生成一个 jwt，jwt 存入 ResponseResult 返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
//        Long id = loginUser.getUser().getId();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        Map<String, Object> map = new HashMap<>();
        map.put("token", jwt);

        // 把完整的用户信息存入 redis userid 作为 key token:jwt
        redisCache.setCacheObject("login:" + userid, loginUser);

        return new ResponseResult(200, "登陆成功", map);
    }

    /**
     * 应在 package com.gfxy.springsecurity.config.SecurityConfig.java 中关闭了 http.scrf()
     * 所以 过滤器不经过 UsernamePasswordAuthenticationToken 导致此方法无效
     * <p>
     * 退出用的是 package com.gfxy.springsecurity.handler.LogoutSuccessHandlerImpl.java
     *
     * @return
     */
    @Override
    public ResponseResult logout() {

        // 获取 SecurityContextHolder 中的用户 id
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authenticationToken.getPrincipal();
        Long userid = loginUser.getUser().getId();

        // 删除 redis 中的值
        redisCache.deleteObject("login:" + userid);
        return new ResponseResult(200, "注销成功");
    }
}
