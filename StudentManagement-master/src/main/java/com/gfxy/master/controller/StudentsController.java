package com.gfxy.master.controller;


import com.gfxy.master.service.StudentsService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.Students;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    public StudentsService studentsService;


    /**
     * 分页请求接口
     *
     * @param pageNum:要显示第几页,默认为     1
     * @param pageSize:每页要显示几条数据,默认为 5
     * @return
     */
    @GetMapping("/admin/students")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<Students> list = studentsService.selectAllStudents();

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<Students> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 根据 studentsId 进行搜索匹配
     *
     * @param studentsId
     * @return
     */
    @PostMapping("/admin/searchByStudentsId")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchByStudentsId(@RequestParam("studentsId") int studentsId) {

        return new ResponseResult(200, "查询成功", studentsService.searchByStudentsId(studentsId));
    }

    /**
     * 根据 name 进行模糊搜索
     *
     * @param name
     * @return
     */
    @PostMapping("/admin/searchStudentsByName")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchStudentsByName(@RequestParam("name") String name) {

        return new ResponseResult(200, "查询成功", studentsService.searchStudentsByName(name));
    }

    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/admin/deleteStudentsById")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult deleteStudentsById(@RequestParam("id") int id) {

        return new ResponseResult(200, "删除成功", studentsService.deleteStudentById(id));
    }

    /**
     * 新增学生
     *
     * @param students
     * @return
     */
    @PostMapping("/admin/insertStudents")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult insertStudents(@RequestBody Students students) {

        if (studentsService.selectStudentsByStudentId(students.getStudentID()) != null) {
            return new ResponseResult(300, "增加失败，该学生编号已有，请重新输入！");
        }
        return new ResponseResult(200, "增加成功", studentsService.insertStudents(students));
    }


    /**
     * 修改学生
     *
     * @param students
     * @return
     */
    @PostMapping("/admin/updateStudents")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult updateStudents(@RequestBody Students students) {
//        if (studentsService.selectStudentsByStudentId(students.getStudentID()) != null) {
//            return new ResponseResult(300, "修改失败，该学生编号已有，请重新输入！");
//        }
        return new ResponseResult(200, "修改成功", studentsService.updateStudents(students));
    }

}

