package com.gfxy.master.controller;

import com.gfxy.master.service.ChangePasswordService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "ChangePasswordController", description = "修改密码控制器")
@RestController
public class ChangePasswordController {

    @Autowired
    private ChangePasswordService changePasswordService;

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @Operation(summary = "修改密码", description = "修改密码")
    @PostMapping("/admin/updatePassword")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult updatePassword(@RequestBody User user) {

        if (changePasswordService.updatePassword(user) == 1) {

            return new ResponseResult(200, "修改成功");

        } else if (changePasswordService.updatePassword(user) == 2) {

            return new ResponseResult(300, "修改失败，与原密码相同");
        }

        return new ResponseResult(300, "修改失败，旧密码输入错误");
    }
}
