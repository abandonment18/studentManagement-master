package com.gfxy.master.controller;

import com.gfxy.master.service.CoursesService;
import com.gfxy.master.service.TeacherCourseService;
import com.gfxy.master.service.TeachersService;
import com.gfxy.master.vo.Courses;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.TeacherCourse;
import com.gfxy.master.vo.Teachers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherCourseController {

    @Autowired
    private TeacherCourseService teacherCourseService;

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private CoursesService coursesService;


    /**
     * 分页请求接口
     *
     * @param pageNum:要显示第几页,默认为     1
     * @param pageSize:每页要显示几条数据,默认为 5
     * @return
     */
    @GetMapping("/admin/teacherCourse")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<TeacherCourse> list = teacherCourseService.selectAllTeacherCourse();

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<TeacherCourse> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 根据 TeachersId 进行搜索匹配
     *
     * @param teacherId
     * @return
     */
    @PostMapping("/admin/searchTeacherCourseByTeachersId")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchTeacherCourseByTeachersId(@RequestParam("teachersId") int teacherId) {

        return new ResponseResult(200, "查询成功", teacherCourseService.searchTeacherCourseByTeachersId(teacherId));
    }

    /**
     * 根据 课程 name 进行模糊搜索
     *
     * @param name
     * @return
     */
    @PostMapping("/admin/searchTeacherCourseByCourseName")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchTeacherCourseByCourseName(@RequestParam("name") String name) {

        return new ResponseResult(200, "查询成功", teacherCourseService.searchTeacherCourseByCourseName(name));
    }

    /**
     * 根据 教师 name  进行模糊搜索
     *
     * @param name
     * @return
     */
    @PostMapping("/admin/searchTeacherCourseByTeacherName")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchTeacherCourseByTeacherName(@RequestParam("name") String name) {

        return new ResponseResult(200, "查询成功", teacherCourseService.searchTeacherCourseByTeacherName(name));
    }

    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/admin/deleteTeacherCourseById")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult deleteTeacherCourseById(@RequestParam("id") int id) {

        return new ResponseResult(200, "删除成功", teacherCourseService.deleteTeacherCourseById(id));
    }

    /**
     * 新增教师授课
     *
     * @param teacherCourse
     * @return
     */
    @PostMapping("/admin/insertTeacherCourse")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult insertTeacherCourse(@RequestBody TeacherCourse teacherCourse) {

        Teachers teachers = teachersService.selectTeachersByTeacherId(teacherCourse.getTeacherID());
        Courses courses = coursesService.selectCoursesByCoursesId(teacherCourse.getCourseID());

        if (courses != null) {
            return new ResponseResult(300, "增加失败，该课程已有！");
        } else if (teachers == null) {
            return new ResponseResult(300, "增加失败，没有该教师！");
        } else if (teachers.getTeacherID() != teacherCourse.getTeacherID()) {
            return new ResponseResult(300, "增加失败，教师编号错误！");
        } else if (!teachers.getName().equals(teacherCourse.getTeacherName())) {
            return new ResponseResult(300, "增加失败，教师名称错误！");
        }
        return new ResponseResult(200, "增加成功", teacherCourseService.insertTeacherCourse(teacherCourse));
    }


    /**
     * 修改教师授课
     *
     * @param teacherCourse
     * @return
     */
    @PostMapping("/admin/updateTeacherCourse")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult updateTeacherCourse(@RequestBody TeacherCourse teacherCourse) {

        Teachers teachers = teachersService.selectTeachersByTeacherId(teacherCourse.getTeacherID());

        if (teachers == null) {
            return new ResponseResult(300, "修改失败，没有该教师！");
        } else if (teachers.getTeacherID() != teacherCourse.getTeacherID()) {
            return new ResponseResult(300, "修改失败，教师编号错误！");
        } else if (!teachers.getName().equals(teacherCourse.getTeacherName())) {
            return new ResponseResult(300, "修改失败，教师名称错误！");
        }
        return new ResponseResult(200, "修改成功", teacherCourseService.updateTeacherCourse(teacherCourse));
    }

}
