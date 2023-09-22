package com.gfxy.master.service;

import com.gfxy.master.vo.PersonalInfo;

public interface PersonalInfoService {

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
     *
     * @param personalInfo
     * @return
     */
    int updatePersonalInfo(PersonalInfo personalInfo);
}
