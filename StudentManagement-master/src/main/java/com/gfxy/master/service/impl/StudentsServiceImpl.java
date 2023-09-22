package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.StudentCourseMapper;
import com.gfxy.master.mapper.StudentsMapper;
import com.gfxy.master.service.StudentsService;
import com.gfxy.master.vo.StudentCourse;
import com.gfxy.master.vo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Override
    public List<Students> selectAllStudents() {
        return studentsMapper.selectAllStudents();
    }

    @Override
    public Students selectStudentsByStudentId(int StudentId) {
        return studentsMapper.selectStudentsByStudentId(StudentId);
    }

    @Override
    public List<Students> searchByStudentsId(int StudentId) {
        return studentsMapper.searchByStudentsId(StudentId);
    }

    @Override
    public List<Students> searchStudentsByName(String name) {
        return studentsMapper.searchStudentsByName(name);
    }

    @Override
    public int deleteStudentById(int id) {
        return studentsMapper.deleteStudentById(id);
    }

    @Override
    public int insertStudents(Students students) {

        // 添加学生（Students 表）
        studentsMapper.insertStudents(students);

        // 根据查到的新添加的信息在学生选课中生成相同信息
        Students students1 = studentsMapper.selectStudentsByStudentId(students.getStudentID());

        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setId(students1.getId());
        studentCourse.setStudentID(students1.getStudentID());
        studentCourse.setStudentName(students1.getName());
        studentCourseMapper.insertStudentCourse(studentCourse);

        return 1;
    }

    @Override
    public int updateStudents(Students students) {

        // 修改学生选课（StudentCourse 表）
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setId(students.getId());
        studentCourse.setStudentID(students.getStudentID());
        studentCourse.setStudentName(students.getName());
        studentCourseMapper.updateStudentCourse(studentCourse);
        return studentsMapper.updateStudents(students);
    }
}
