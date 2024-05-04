package com.gfxy.master.controller;

import com.gfxy.master.service.UserService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "UserController", description = "用户管理")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页请求接口
     *
     * @param pageNum:要显示第几页,默认为     1
     * @param pageSize:每页要显示几条数据,默认为 5
     * @return
     */
    @Operation(summary = "分页查询用户", description = "分页查询用户")
    @GetMapping("/admin/user")
    @PreAuthorize("hasAnyAuthority('system:dept:list')")
    public ResponseResult selectByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<User> list = userService.selectUserList();

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<User> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 根据 id 进行删除
     *
     * @param id
     * @return
     */
    @Operation(summary = "根据 id 进行删除", description = "根据 id 进行删除")
    @GetMapping("/admin/deleteUserById")
    @PreAuthorize("hasAnyAuthority('system:dept:list')")
    public ResponseResult deleteUserById(@RequestParam("id") int id) {
        return new ResponseResult(200, "删除成功", userService.deleteUserById(id));
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Operation(summary = "修改用户", description = "修改用户")
    @PostMapping("/admin/updateUser")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult updateUser(@RequestBody User user) {
        return new ResponseResult(200, "修改成功", userService.updateUser(user));
    }
}
