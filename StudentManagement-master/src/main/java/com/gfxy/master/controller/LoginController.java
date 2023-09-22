package com.gfxy.master.controller;

import com.gfxy.master.service.LoginService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * register.vue 的登陆查询与注册
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 登录
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        // 登录
        return loginService.login(user);
    }

//    @PostMapping("/user/index")
//    @PreAuthorize("hasAuthority('system:dept:list')")
//    public ResponseResult isView() {
//        return new ResponseResult(200, "查看");
//    }


}
