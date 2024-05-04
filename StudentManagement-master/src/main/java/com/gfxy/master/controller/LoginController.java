package com.gfxy.master.controller;

import com.gfxy.master.service.LoginService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * register.vue 的登陆查询与注册
 */
@Tag(name = "LoginController", description = "登录控制器")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "登录", description = "登录")
    // 登录
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        System.out.println(user);
        // 登录
        return loginService.login(user);
    }

//    @PostMapping("/user/index")
//    @PreAuthorize("hasAuthority('system:dept:list')")
//    public ResponseResult isView() {
//        return new ResponseResult(200, "查看");
//    }


}
