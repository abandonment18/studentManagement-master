package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.StudentCourseMapper;
import com.gfxy.master.service.StudentCourseService;
import com.gfxy.master.vo.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Override
    public List<StudentCourse> selectAllStudentCourse() {
        return studentCourseMapper.selectAllStudentCourse();
    }

    @Override
    public List<StudentCourse> selectStudentCourseById(int id) {
        return studentCourseMapper.selectStudentCourseById(id);
    }

    @Override
    public StudentCourse selectStudentCourseByStudentId(int StudentId) {
        return studentCourseMapper.selectStudentCourseByStudentId(StudentId);
    }

    @Override
    public List<StudentCourse> searchStudentCourseByStudentId(int StudentId) {
        return studentCourseMapper.searchStudentCourseByStudentId(StudentId);
    }

    @Override
    public List<StudentCourse> searchStudentCourseByStudentName(String name) {
        return studentCourseMapper.searchStudentCourseByStudentName(name);
    }

    @Override
    public List<StudentCourse> searchStudentCourseByCourseName(String name) {
        return studentCourseMapper.searchStudentCourseByCourseName(name);
    }

    @Override
    public int deleteStudentCourseById(int id) {
        return studentCourseMapper.deleteStudentCourseById(id);
    }

    @Override
    public int insertStudentCourse(StudentCourse studentCourse) {
        return studentCourseMapper.insertStudentCourse(studentCourse);
    }

    @Override
    public int updateStudentCourse(StudentCourse studentCourse) {
        return studentCourseMapper.updateStudentCourse(studentCourse);
    }
}
