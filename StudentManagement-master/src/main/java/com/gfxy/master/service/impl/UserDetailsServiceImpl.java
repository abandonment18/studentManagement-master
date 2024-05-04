package com.gfxy.master.service.impl;

import com.gfxy.master.service.MenuService;
import com.gfxy.master.service.UserService;
import com.gfxy.master.vo.LoginUser;
import com.gfxy.master.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 重写 security 中自带的根据 用户对应的权限信息 在数据库中查找
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询用户信息
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getUserName, username);
//        System.out.println(queryWrapper.eq(User::getUserName, username));
        User user = userService.selectUserByUsername(username);
//        System.out.println(new LoginUser(user));
        // 如果没有查询到用户就抛出异常
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 写固定 权限信息
//        List<String> list = new ArrayList<>(Arrays.asList("test", "admin"));
        // 在数据库中查询对应的权限信息
        List<String> list = menuService.selectPermsByUserId(user.getId());

        // 把数据封装成 UserDetails 返回
        // domain > LoginUser.java 实现了 UserDetails 方法
        return new LoginUser(user, list);
    }
}
