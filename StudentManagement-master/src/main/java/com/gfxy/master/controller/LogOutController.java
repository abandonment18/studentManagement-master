package com.gfxy.master.controller;

import com.gfxy.master.service.LoginService;
import com.gfxy.master.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogOutController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/logout")
    public ResponseResult logout() {
        // 退出
        return loginService.logout();
    }
}
