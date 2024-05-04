package com.gfxy.master.service;

import com.gfxy.master.vo.Students;

import java.util.List;

public interface StudentsService {

    /**
     * 查询所有学生信息
     *
     * @return
     */
    List<Students> selectAllStudents();

    /**
     * 根据 StudentId 查询
     *
     * @param StudentId
     * @return
     */
    Students selectStudentsByStudentId(int StudentId);

    /**
     * 根据学生编号模糊查询所有字段
     *
     * @return
     */
    List<Students> searchByStudentsId(int StudentId);

    /**
     * 根据名称模糊查询所有字段
     *
     * @return
     */
    List<Students> searchStudentsByName(String name);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteStudentById(int id);


    /**
     * 增加
     *
     * @param students
     * @return
     */
    int insertStudents(Students students);

    /**
     * 修改
     *
     * @param students
     * @return
     */
    int updateStudents(Students students);

    /**
     * 查询所有学生总数
     *
     * @return
     */
    int selectStudentCount();
}
