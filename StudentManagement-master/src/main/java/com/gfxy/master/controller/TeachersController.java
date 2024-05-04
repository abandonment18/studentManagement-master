package com.gfxy.master.controller;

import com.gfxy.master.service.TeachersService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.Teachers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TeachersController", description = "教师管理")
@RestController
public class TeachersController {

    @Autowired
    public TeachersService teachersService;


    /**
     * 分页请求接口
     *
     * @param pageNum:要显示第几页,默认为     1
     * @param pageSize:每页要显示几条数据,默认为 5
     * @return
     */
    @Operation(summary = "分页查询教师", description = "分页查询教师")
    @GetMapping("/admin/teachers")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<Teachers> list = teachersService.selectAllTeachers();

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<Teachers> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 根据 TeachersId 进行搜索匹配
     *
     * @param teacherId
     * @return
     */
    @Operation(summary = "根据 TeachersId 进行搜索匹配", description = "根据 TeachersId 进行搜索匹配")
    @GetMapping("/admin/searchByTeachersId")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchByTeachersId(@RequestParam("teachersId") int teacherId) {

        return new ResponseResult(200, "查询成功", teachersService.searchByTeachersId(teacherId));
    }

    /**
     * 根据 name 进行模糊搜索
     *
     * @param name
     * @return
     */
    @Operation(summary = "根据 name 进行模糊搜索", description = "根据 name 进行模糊搜索")
    @GetMapping("/admin/searchByName")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchByName(@RequestParam("name") String name) {

        return new ResponseResult(200, "查询成功", teachersService.searchByName(name));
    }

    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    @Operation(summary = "根据 id 删除", description = "根据 id 删除")
    @GetMapping("/admin/deleteTeachersById")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult deleteTeachersById(@RequestParam("id") int id) {

        return new ResponseResult(200, "删除成功", teachersService.deleteTeacherById(id));
    }

    /**
     * 新增教师
     *
     * @param teachers
     * @return
     */
    @Operation(summary = "新增教师", description = "新增教师")
    @PostMapping("/admin/insertTeachers")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult insertTeachers(@RequestBody Teachers teachers) {


        if (teachersService.selectTeachersByTeacherId(teachers.getTeacherID()) != null) {
            return new ResponseResult(300, "增加失败，该教师编号已有，请重新输入！");
        }
        return new ResponseResult(200, "增加成功", teachersService.insertTeachers(teachers));
    }


    /**
     * 修改教师
     *
     * @param teachers
     * @return
     */
    @Operation(summary = "修改教师", description = "修改教师")
    @PostMapping("/admin/updateTeachers")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult updateTeachers(@RequestBody Teachers teachers) {
//        if (teachersService.selectTeachersByTeacherId(teachers.getTeacherID()) != null) {
//            return new ResponseResult(300, "修改失败，该教师编号已有，请重新输入！");
//        }
        return new ResponseResult(200, "修改成功", teachersService.updateTeachers(teachers));
    }

}
