package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.CoursesMapper;
import com.gfxy.master.mapper.TeacherCourseMapper;
import com.gfxy.master.mapper.TeachersMapper;
import com.gfxy.master.service.TeacherCourseService;
import com.gfxy.master.vo.Courses;
import com.gfxy.master.vo.TeacherCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Autowired
    private TeachersMapper teachersMapper;

    @Autowired
    private CoursesMapper coursesMapper;


    @Override
    public List<TeacherCourse> selectAllTeacherCourse() {
        return teacherCourseMapper.selectAllTeacherCourse();
    }

    @Override
    public TeacherCourse selectTeacherCourseByTeacherId(int TeacherId) {
        return teacherCourseMapper.selectTeacherCourseByTeacherId(TeacherId);
    }

    @Override
    public List<TeacherCourse> searchTeacherCourseByTeachersId(int teacherId) {
        return teacherCourseMapper.searchTeacherCourseByTeachersId(teacherId);
    }

    @Override
    public List<TeacherCourse> searchTeacherCourseByTeacherName(String name) {
        return teacherCourseMapper.searchTeacherCourseByTeacherName(name);
    }

    @Override
    public List<TeacherCourse> searchTeacherCourseByCourseName(String name) {
        return teacherCourseMapper.searchTeacherCourseByCourseName(name);
    }

    @Override
    public int deleteTeacherCourseById(int id) {
        return teacherCourseMapper.deleteTeacherCourseById(id);
    }

    @Override
    public int insertTeacherCourse(TeacherCourse teacherCourse) {

        // 添加教师授课（TeacherCourse 表）信息时 并为课程表（Courses）添加相应的信息
        teacherCourseMapper.insertTeacherCourse(teacherCourse);

        Courses courses = new Courses();
        courses.setId(teachersMapper.selectTeachersByTeacherId(teacherCourse.getTeacherID()).getId());
        courses.setCourseID(teacherCourse.getCourseID());
        courses.setCourseName(teacherCourse.getCourseName());
        courses.setTeacherID(teacherCourse.getTeacherID());
        courses.setDepartmentOffering(teachersMapper.selectTeachersByTeacherId(teacherCourse.getTeacherID()).getDepartment());
        coursesMapper.insertCourses(courses);

        return 1;
    }

    @Override
    public int updateTeacherCourse(TeacherCourse teacherCourse) {

        // 修改教师授课（TeacherCourse 表）信息 并修改课程（Courses 表）信息
        Courses courses = new Courses();
        courses.setId(teachersMapper.selectTeachersByTeacherId(teacherCourse.getTeacherID()).getId());
        courses.setCourseID(teacherCourse.getCourseID());
        courses.setCourseName(teacherCourse.getCourseName());
        courses.setTeacherID(teacherCourse.getTeacherID());
        courses.setDepartmentOffering(teachersMapper.selectTeachersByTeacherId(teacherCourse.getTeacherID()).getDepartment());
        coursesMapper.updateCourses(courses);

        return teacherCourseMapper.updateTeacherCourse(teacherCourse);
    }
}
