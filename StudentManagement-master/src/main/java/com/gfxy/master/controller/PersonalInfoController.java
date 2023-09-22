package com.gfxy.master.controller;

import com.gfxy.master.service.PersonalInfoService;
import com.gfxy.master.utils.JwtUtil;
import com.gfxy.master.vo.PersonalInfo;
import com.gfxy.master.vo.ResponseResult;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    /**
     * 根据 token 查询个人信息
     *
     * @param request
     * @return
     */
    @PostMapping("/admin/selectPersonInfo")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectPersonInfo(HttpServletRequest request) {

//        String token = requestInfo.getToken();
        String token = request.getHeader("Authorization").substring(7);
//        System.out.println(token);
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
//            System.out.println(claims);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 从 token 中获取当前用户 id
        int id = Integer.parseInt(userid);

        // 使用用户 id 查询其权限
        // 根据权限判断查询学生表还是教师表
        int Permissions = personalInfoService.selectPersonalInfoById(id);

        if (Permissions == 1) {
            return new ResponseResult(200, "查询成功", personalInfoService.selectTeachersById(id));
        } else if (Permissions == 2) {
            return new ResponseResult(200, "查询成功", personalInfoService.selectStudentsById(id));
        } else {
            return new ResponseResult(403, "出错，请联系管理员");
        }
    }

    /**
     * 修改个人信息
     *
     * @param personalInfo
     * @return
     */
    @PostMapping("/admin/updatePersonInfo")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult updatePersonInfo(@RequestBody PersonalInfo personalInfo) {
        if (personalInfoService.updatePersonalInfo(personalInfo) == 1) {
            return new ResponseResult(200, "修改成功");
        }
        return new ResponseResult(300, "修改失败");
    }
}
