package com.gfxy.master.service;

import com.gfxy.master.vo.StudentCourse;

import java.util.List;

public interface StudentCourseService {

    /**
     * 查询所有学生选课信息
     *
     * @return
     */
    List<StudentCourse> selectAllStudentCourse();

    /**
     * 查询单个学生选课信息
     *
     * @return
     */
    List<StudentCourse> selectStudentCourseById(int id);

    /**
     * 根据 StudentId 查询
     *
     * @param StudentId
     * @return
     */
    StudentCourse selectStudentCourseByStudentId(int StudentId);

    /**
     * 根据教师编号模糊查询所有字段
     *
     * @return
     */
    List<StudentCourse> searchStudentCourseByStudentId(int StudentId);

    /**
     * 根据教师名称模糊查询所有字段
     *
     * @return
     */
    List<StudentCourse> searchStudentCourseByStudentName(String name);

    /**
     * 根据课程名称模糊查询所有字段
     *
     * @return
     */
    List<StudentCourse> searchStudentCourseByCourseName(String name);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteStudentCourseById(int id);


    /**
     * 增加
     *
     * @param studentCourse
     * @return
     */
    int insertStudentCourse(StudentCourse studentCourse);

    /**
     * 修改
     *
     * @param studentCourse
     * @return
     */
    int updateStudentCourse(StudentCourse studentCourse);
}
