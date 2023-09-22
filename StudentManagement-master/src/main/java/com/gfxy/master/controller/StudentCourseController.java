package com.gfxy.master.controller;

import com.gfxy.master.service.CoursesService;
import com.gfxy.master.service.StudentCourseService;
import com.gfxy.master.service.StudentsService;
import com.gfxy.master.vo.Courses;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.StudentCourse;
import com.gfxy.master.vo.Students;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentCourseController {

    @Autowired
    public StudentCourseService studentCourseService;

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private StudentsService studentsService;


    /**
     * 分页请求接口
     *
     * @param pageNum:要显示第几页,默认为     1
     * @param pageSize:每页要显示几条数据,默认为 5
     * @return
     */
    @GetMapping("/admin/studentCourse")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<StudentCourse> list = studentCourseService.selectAllStudentCourse();

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<StudentCourse> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    @GetMapping("/admin/selectStudentCourseInfoByStudentId")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectStudentCourseInfoByStudentId(@RequestParam Integer id, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<StudentCourse> list = studentCourseService.selectStudentCourseById(id);

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<StudentCourse> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 查询所有课程
     *
     * @return
     */
    @GetMapping("/admin/selectAllCourseInfo")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectAllCourseInfo() {

        return new ResponseResult(200, "查询成功", coursesService.selectAllCourses());
    }


    /**
     * 根据 studentId 进行搜索匹配
     *
     * @param studentId
     * @return
     */
    @PostMapping("/admin/searchStudentCourseByStudentId")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchStudentCourseByStudentId(@RequestParam("studentId") int studentId) {

        return new ResponseResult(200, "查询成功", studentCourseService.searchStudentCourseByStudentId(studentId));
    }

    /**
     * 根据 课程 name 进行模糊搜索
     *
     * @param name
     * @return
     */
    @PostMapping("/admin/searchStudentCourseByCourseName")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchStudentCourseByCourseName(@RequestParam("name") String name) {

        return new ResponseResult(200, "查询成功", studentCourseService.searchStudentCourseByCourseName(name));
    }

    /**
     * 根据 学生 name  进行模糊搜索
     *
     * @param name
     * @return
     */
    @PostMapping("/admin/searchStudentCourseByStudentName")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchStudentCourseByStudentName(@RequestParam("name") String name) {

        return new ResponseResult(200, "查询成功", studentCourseService.searchStudentCourseByStudentName(name));
    }

    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/admin/deleteStudentCourseById")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult deleteStudentCourseById(@RequestParam("id") int id) {

        return new ResponseResult(200, "删除成功", studentCourseService.deleteStudentCourseById(id));
    }

    /**
     * 新增学生选课
     *
     * @param studentCourse
     * @return
     */
    @PostMapping("/admin/insertStudentCourse")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult insertStudentCourse(@RequestBody StudentCourse studentCourse) {

        Courses courses = coursesService.selectCoursesByCoursesId(studentCourse.getCourseID());
        studentCourse.setCourseName(courses.getCourseName());
        Students students = studentsService.selectStudentsByStudentId(studentCourse.getStudentID());
        if (courses == null) {
            return new ResponseResult(300, "增加失败，没有该课程编号！");
        } else if (students == null) {
            return new ResponseResult(300, "增加失败，没有该学生！");
        } else if (courses.getCourseID() != studentCourse.getCourseID()) {
            return new ResponseResult(300, "增加失败，课程编号错误！");
        } else if (!courses.getCourseName().equals(studentCourse.getCourseName())) {
            return new ResponseResult(300, "增加失败，课程名称错误！");
        } else if (!students.getName().equals(studentCourse.getStudentName())) {
            return new ResponseResult(300, "增加失败，没有该学生名称！");
        } else if (students.getStudentID() != studentCourse.getStudentID()) {
            return new ResponseResult(300, "增加失败，没有该学生编号！");
        }
        return new ResponseResult(200, "增加成功", studentCourseService.insertStudentCourse(studentCourse));
    }


    /**
     * 修改学生选课
     *
     * @param studentCourse
     * @return
     */
    @PostMapping("/admin/updateStudentCourse")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult updateStudentCourse(@RequestBody StudentCourse studentCourse) {

        Courses courses = coursesService.selectCoursesByCoursesId(studentCourse.getCourseID());
        studentCourse.setCourseName(courses.getCourseName());
        Students students = studentsService.selectStudentsByStudentId(studentCourse.getStudentID());
        if (courses == null) {
            return new ResponseResult(300, "修改失败，没有该课程编号！");
        } else if (students == null) {
            return new ResponseResult(300, "修改失败，没有该学生！");
        } else if (courses.getCourseID() != studentCourse.getCourseID()) {
            return new ResponseResult(300, "修改失败，课程编号错误！");
        } else if (!courses.getCourseName().equals(studentCourse.getCourseName())) {
            return new ResponseResult(300, "修改失败，课程名称错误！");
        } else if (!students.getName().equals(studentCourse.getStudentName())) {
            return new ResponseResult(300, "修改失败，没有该学生名称！");
        } else if (students.getStudentID() != studentCourse.getStudentID()) {
            return new ResponseResult(300, "修改失败，没有该学生编号！");
        }
        return new ResponseResult(200, "修改成功", studentCourseService.updateStudentCourse(studentCourse));
    }
}
