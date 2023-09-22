package com.gfxy.master.service;

import com.gfxy.master.vo.Register;

public interface RegisterService {

    /**
     * 注册学生表
     *
     * @param register
     * @return
     */
    int insertStudents(Register register);

    /**
     * 注册教师表
     *
     * @param register
     * @return
     */
    int insertTeachers(Register register);
}
