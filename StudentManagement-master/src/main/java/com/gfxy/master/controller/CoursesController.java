package com.gfxy.master.controller;

import com.gfxy.master.service.CoursesService;
import com.gfxy.master.service.TeachersService;
import com.gfxy.master.vo.Courses;
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

/**
 * AllUser.vue 中列表的删改
 * 两表 user user_details
 */
@Tag(name = "CoursesController", description = "课程控制器")
@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private TeachersService teachersService;


    /**
     * 分页请求接口
     *
     * @param pageNum:要显示第几页,默认为     1
     * @param pageSize:每页要显示几条数据,默认为 5
     * @return
     */
    @Operation(summary = "分页查询课程", description = "分页查询课程")
    @GetMapping("/admin/courses")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<Courses> list = coursesService.selectAllCourses();

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<Courses> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 查询所有课程
     *
     * @return
     */
    @Operation(summary = "查询所有课程", description = "查询所有课程")
    @GetMapping("/admin/selectAllCoursesInfoList")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectAllCoursesInfoList() {

        return new ResponseResult(200, "查询成功", coursesService.selectAllCourses());
    }

    /**
     * 根据 CoursesId 进行搜索
     *
     * @param CoursesId
     * @return
     */
    @Operation(summary = "根据 CoursesId 进行搜索", description = "根据 CoursesId 进行搜索")
    @GetMapping("/admin/searchByCoursesId")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchByCoursesId(@RequestParam("CoursesId") int CoursesId) {

        return new ResponseResult(200, "查询成功", coursesService.searchByCoursesId(CoursesId));
    }

    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    @Operation(summary = "根据 id 删除", description = "根据 id 删除")
    @GetMapping("/admin/deleteCoursesById")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult deleteCoursesById(@RequestParam("id") int id) {

        return new ResponseResult(200, "删除成功", coursesService.deleteCoursesById(id));
    }

    /**
     * 新增
     *
     * @param courses
     * @return
     */
    @Operation(summary = "新增课程", description = "新增课程")
    @PostMapping("/admin/insertCourses")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult insertCourses(@RequestBody Courses courses) {

        Teachers teachers = teachersService.selectTeachersByTeacherId(courses.getTeacherID());

        if (coursesService.selectCoursesByCoursesId(courses.getCourseID()) != null) {
            return new ResponseResult(300, "增加失败,该课程已有");
        } else if (teachers == null) {
            return new ResponseResult(300, "增加失败,没有该教师");
        } else if (teachers.getTeacherID() != (courses.getTeacherID())) {
            return new ResponseResult(300, "增加失败,该教师编号错误");
        } else if (!teachers.getDepartment().equals(courses.getDepartmentOffering())) {
            return new ResponseResult(300, "增加失败,该教师所属学院错误");
        }
        return new ResponseResult(200, "增加成功", coursesService.insertCourses(courses));

    }

    /**
     * 修改
     *
     * @param courses
     * @return
     */
    @Operation(summary = "修改课程", description = "修改课程")
    @PostMapping("/admin/updateCourses")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult updateCourses(@RequestBody Courses courses) {

        Teachers teachers = teachersService.selectTeachersByTeacherId(courses.getTeacherID());

        if (teachers == null) {
            return new ResponseResult(300, "修改失败，没有该教师");
        } else if (teachers.getTeacherID() != (courses.getTeacherID())) {
            return new ResponseResult(300, "修改失败，该教师编号错误");
        } else if (!teachers.getDepartment().equals(courses.getDepartmentOffering())) {
            return new ResponseResult(300, "修改失败，该教师所属学院错误");
        }
        return new ResponseResult(200, "修改成功", coursesService.updateCourses(courses));
    }

}
