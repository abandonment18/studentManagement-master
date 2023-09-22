package com.gfxy.master.mapper;

import com.gfxy.master.vo.PersonalInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalInfoMapper {

    /**
     * 根据 id 查询权限 id
     *
     * @param id
     * @return
     */
    int selectPersonalInfoById(int id);

    /**
     * 根据 id 查询教师对象
     *
     * @param id
     * @return
     */
    PersonalInfo selectTeachersById(int id);

    /**
     * 根据 id 查询学生对象
     *
     * @param id
     * @return
     */
    PersonalInfo selectStudentsById(int id);

    /**
     * 修改个人信息
     * 教师 是修改 user表 与 教师表
     * 学生 是修改 user表 与 学生表
     *
     * @param personalInfo
     * @return
     */
    int updateStudents(PersonalInfo personalInfo);

    int updateUser(PersonalInfo personalInfo);

    int updateTeachers(PersonalInfo personalInfo);

}
