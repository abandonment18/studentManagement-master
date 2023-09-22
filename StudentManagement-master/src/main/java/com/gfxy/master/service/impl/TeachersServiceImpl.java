package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.CoursesMapper;
import com.gfxy.master.mapper.TeacherCourseMapper;
import com.gfxy.master.mapper.TeachersMapper;
import com.gfxy.master.mapper.UnitsMapper;
import com.gfxy.master.service.TeachersService;
import com.gfxy.master.vo.Courses;
import com.gfxy.master.vo.TeacherCourse;
import com.gfxy.master.vo.Teachers;
import com.gfxy.master.vo.Units;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private TeachersMapper teachersMapper;

    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private UnitsMapper unitsMapper;

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Override
    public List<Teachers> selectAllTeachers() {
        return teachersMapper.selectAllTeachers();
    }

    @Override
    public Teachers selectTeachersByTeacherId(int TeacherId) {
        return teachersMapper.selectTeachersByTeacherId(TeacherId);
    }

    @Override
    public List<Teachers> selectListTeachersByTeacherId(int TeacherId) {
        return teachersMapper.selectListTeachersByTeacherId(TeacherId);
    }

    @Override
    public List<Teachers> searchByTeachersId(int teacherId) {
        return teachersMapper.searchByTeachersId(teacherId);
    }

    @Override
    public List<Teachers> searchByName(String name) {
        return teachersMapper.searchByName(name);
    }

    @Override
    public int deleteTeacherById(int id) {
        return teachersMapper.deleteTeacherById(id);
    }

    @Override
    public int insertTeachers(Teachers teachers) {

        // 添加教师（Teachers）时 为课程表（Courses 表）预留一个 id 为以后教师授课（TeacherCourse 表）可以查询到相应的信息
        teachersMapper.insertTeachers(teachers);

        Teachers teachers1 = teachersMapper.selectTeachersByTeacherId(teachers.getTeacherID());

        // 判断 课程表中 是否有相同的 id 防止报错
        if (coursesMapper.selectCoursesById(teachers1.getId()) == null || coursesMapper.selectCoursesByCoursesId(teachers1.getId()).getId() != teachers1.getId()) {
            Courses courses = new Courses();
            courses.setId(teachers1.getId());
//        courses.setDepartmentOffering(teachers1.getDepartment());
//        courses.setTeacherID(teachers1.getTeacherID());
            coursesMapper.insertCourses(courses);
        }


        // 并以相同的信息往教师单位（Units 表）中添加
        Units units = new Units();
        units.setId(teachers1.getId());
        units.setTeacherID(teachers1.getTeacherID());
        units.setTeacherName(teachers1.getName());
        units.setUnitName(teachers1.getDepartment());
        unitsMapper.insertUnits(units);

        // 并以相同的信息往教师授课（TeacherCourse 表）中添加
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setId(teachers1.getId());
        teacherCourse.setTeacherID(teachers1.getTeacherID());
        teacherCourse.setTeacherName(teachers1.getName());
        teacherCourseMapper.insertTeacherCourse(teacherCourse);
        return 1;
    }

    @Override
    public int updateTeachers(Teachers teachers) {

        // 修改教师 所对应的课程（Courses 表）的id
        Courses courses = new Courses();
        courses.setId(teachers.getId());
//        courses.setDepartmentOffering(teachers.getDepartment());
//        courses.setTeacherID(teachers.getTeacherID());
        coursesMapper.updateCourses(courses);

        // 修改相同教师单位（Units 表）的信息
        Units units = new Units();
        units.setId(teachers.getId());
        units.setTeacherID(teachers.getTeacherID());
        units.setTeacherName(teachers.getName());
        units.setUnitName(teachers.getDepartment());
        unitsMapper.updateUnits(units);

        // 修改相同教师授课（TeacherCourse）的信息
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setId(teachers.getId());
        teacherCourse.setTeacherID(teachers.getTeacherID());
        teacherCourse.setTeacherName(teachers.getName());
        teacherCourseMapper.updateTeacherCourse(teacherCourse);

        return teachersMapper.updateTeachers(teachers);
    }
}
