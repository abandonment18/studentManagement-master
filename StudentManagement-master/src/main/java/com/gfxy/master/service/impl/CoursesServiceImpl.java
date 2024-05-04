package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.CoursesMapper;
import com.gfxy.master.mapper.StudentCourseMapper;
import com.gfxy.master.mapper.TeacherCourseMapper;
import com.gfxy.master.mapper.TeachersMapper;
import com.gfxy.master.service.CoursesService;
import com.gfxy.master.vo.Courses;
import com.gfxy.master.vo.StudentCourse;
import com.gfxy.master.vo.TeacherCourse;
import com.gfxy.master.vo.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CoursesServiceImpl implements CoursesService {


    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Autowired
    private TeachersMapper teachersMapper;

    @Override
    public List<Courses> selectAllCourses() {
        List<Courses> list = coursesMapper.selectAllCourses();
        for (Courses courses : coursesMapper.selectStudentCoursesNameCountByCourseName()) {
            for (Courses courses1 : list) {
                if (courses.getCourseID() == courses1.getCourseID()) {
                    courses1.setCount(courses.getCount());
                }
            }
        }
        return list;
    }

    @Override
    public Courses selectCoursesByCoursesId(int StudentId) {
        return coursesMapper.selectCoursesByCoursesId(StudentId);
    }

    @Override
    public Courses selectCoursesById(int id) {
        return coursesMapper.selectCoursesById(id);
    }

    @Override
    public List<Courses> searchByCoursesId(int coursesId) {
        return coursesMapper.searchByCoursesId(coursesId);
    }

    @Override
    public int deleteCoursesById(int id) {
        return coursesMapper.deleteCoursesById(id);
    }

    @Override
    public int insertCourses(Courses courses) {
        coursesMapper.insertCourses(courses);
        Courses courses1 = coursesMapper.selectCoursesByCoursesId(courses.getCourseID());

//        StudentCourse studentCourse = new StudentCourse();
//        studentCourse.setId(courses1.getId());
//        studentCourse.setCourseID(courses1.getCourseID());
//        studentCourse.setCourseName(courses1.getCourseName());
//        studentCourseMapper.insertStudentCourse(studentCourse);

        System.out.println(courses);
        Teachers teachers = teachersMapper.selectTeachersByTeacherId(courses.getTeacherID());
        TeacherCourse teacherCourse = new TeacherCourse();
        // 如果teachers
        if (Objects.isNull(teachers)) {
            // 增加 课程（courses 表） 时为 教师授课（TeacherCourse 表） 也添加 相同信息
            teacherCourse.setId(courses1.getId());
            teacherCourse.setTeacherID(courses1.getTeacherID());
            teacherCourse.setTeacherName(teachersMapper.selectTeachersByTeacherId(courses1.getTeacherID()).getName());
            teacherCourse.setCourseID(courses1.getCourseID());
            teacherCourse.setCourseName(courses1.getCourseName());
            teacherCourseMapper.insertTeacherCourse(teacherCourse);
        } else {
            teacherCourse.setId(teachers.getId());
            teacherCourse.setTeacherID(teachers.getTeacherID());
            teacherCourse.setTeacherName(teachers.getName());
            teacherCourse.setCourseID(courses1.getCourseID());
            teacherCourse.setCourseName(courses1.getCourseName());
            teacherCourseMapper.updateTeacherCourse(teacherCourse);
        }


        return 1;
    }

    @Override
    public int updateCourses(Courses courses) {


        TeacherCourse teacherCourse1 = teacherCourseMapper.selectTeacherCourseByTeacherIdAndCourseId(courses);

        Teachers teachers = teachersMapper.selectTeachersByTeacherId(courses.getTeacherID());

        TeacherCourse teacherCourse = new TeacherCourse();
        if (Objects.isNull(teacherCourse1)) {
            teacherCourse.setTeacherID(courses.getTeacherID());
            teacherCourse.setCourseID(courses.getCourseID());
            teacherCourse.setTeacherName(teachers.getName());
            teacherCourse.setCourseName(courses.getCourseName());
            teacherCourseMapper.insertTeacherCourse(teacherCourse);
        } else {
            // 修改教师授课（TeacherCourse 表）中的信息
            teacherCourse.setId(courses.getId());
            teacherCourse.setTeacherID(courses.getTeacherID());
            teacherCourse.setCourseID(courses.getCourseID());
            teacherCourse.setTeacherName(teachers.getName());
            teacherCourse.setCourseName(courses.getCourseName());
            teacherCourseMapper.updateTeacherCourse(teacherCourse);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + courses);

        // 修改学生（StudentCourse 表）选课中的信息
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setId(courses.getId());
        studentCourse.setCourseID(courses.getCourseID());
        studentCourse.setCourseName(courses.getCourseName());
        studentCourseMapper.updateStudentCourse(studentCourse);


        // 修改课程（Courses 表）
        return coursesMapper.updateCourses(courses);
    }

}
