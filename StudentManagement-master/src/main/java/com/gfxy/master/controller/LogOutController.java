package com.gfxy.master.controller;

import com.gfxy.master.service.LoginService;
import com.gfxy.master.vo.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "LogOutController", description = "退出控制器")
@RestController
public class LogOutController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "退出", description = "退出")
    @PostMapping("/logout")
    public ResponseResult logout() {
        // 退出
        return loginService.logout();
    }
}
