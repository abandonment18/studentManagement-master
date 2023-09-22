package com.gfxy.master.service;

import com.gfxy.master.vo.Teachers;

import java.util.List;

public interface TeachersService {

    /**
     * 查询所有教师信息
     *
     * @return
     */
    List<Teachers> selectAllTeachers();

    /**
     * 根据 TeacherId 查询
     *
     * @param TeacherId
     * @return
     */
    Teachers selectTeachersByTeacherId(int TeacherId);

    /**
     * 根据 TeacherId 查询
     * 查询到多个教师
     *
     * @param TeacherId
     * @return
     */
    List<Teachers> selectListTeachersByTeacherId(int TeacherId);

    /**
     * 根据教师编号模糊查询所有字段
     *
     * @return
     */
    List<Teachers> searchByTeachersId(int teacherId);

    /**
     * 根据名称模糊查询所有字段
     *
     * @return
     */
    List<Teachers> searchByName(String name);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteTeacherById(int id);


    /**
     * 增加
     *
     * @param teachers
     * @return
     */
    int insertTeachers(Teachers teachers);

    /**
     * 修改
     *
     * @param teachers
     * @return
     */
    int updateTeachers(Teachers teachers);


}
