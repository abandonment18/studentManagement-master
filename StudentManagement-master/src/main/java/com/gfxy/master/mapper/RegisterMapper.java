package com.gfxy.master.mapper;

import com.gfxy.master.vo.Register;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

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

    /**
     * 注册 User表
     *
     * @param register
     * @return
     */
    int insertUser(Register register);

    /**
     * 注册 角色 权限 对应表
     *
     * @param register
     * @return
     */
    int insertUserRole(Register register);
}
