package com.gfxy.master.controller;

import com.gfxy.master.service.RegisterService;
import com.gfxy.master.vo.Register;
import com.gfxy.master.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册
 * 学生没有权限
 * 只有教师才可以注册 学生 或者 教师
 */
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 注册学生
     *
     * @param register
     * @return
     */
    @PostMapping("/admin/registerStudents")
    @PreAuthorize("hasAnyAuthority('system:dept:list')")
    public ResponseResult registerStudents(@RequestBody Register register) {

        System.out.println(register);

        // 学生的用户类型为 1（普通用户）
        register.setUserType("1");

        // 密码加密
        register.setPassword(passwordEncoder.encode(register.getPassword()));

        // 角色 id 学生默认为 2
        register.setRoleId(2);

        if (registerService.insertStudents(register) == 1) {

            return new ResponseResult(200, "注册成功");

        } else if (registerService.insertStudents(register) == 2) {

            return new ResponseResult(300, "注册失败，该学生编号已被注册");
        }
        return new ResponseResult(300, "注册失败，该学生用户名已被注册");
    }

    /**
     * 注册教师
     *
     * @param register
     * @return
     */
    @PostMapping("/admin/registerTeachers")
    @PreAuthorize("hasAnyAuthority('system:dept:list')")
    public ResponseResult registerTeachers(@RequestBody Register register) {

        // 教师的用户类型为 0（管理员）
        register.setUserType("0");

        // 密码加密
        register.setPassword(passwordEncoder.encode(register.getPassword()));

        // 角色 id 教师默认为 1
        register.setRoleId(1);

        if (registerService.insertTeachers(register) == 1) {

            return new ResponseResult(200, "注册成功");

        } else if (registerService.insertTeachers(register) == 2) {

            return new ResponseResult(300, "注册失败，该教师已被注册");
        }
        return new ResponseResult(300, "注册失败，该教师已被注册");
    }
}
