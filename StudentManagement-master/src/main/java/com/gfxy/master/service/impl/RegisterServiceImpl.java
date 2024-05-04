package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.RegisterMapper;
import com.gfxy.master.service.*;
import com.gfxy.master.vo.Register;
import com.gfxy.master.vo.Students;
import com.gfxy.master.vo.Units;
import com.gfxy.master.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private UserService userService;

    @Autowired
    private UnitsService unitsService;

    @Override
    public int insertStudents(Register register) {

        // 查询是否有相同的用户名 如果有 则提示 该用户名已被注册
        if (userService.selectUserByUsername(register.getUsername()) == null) {

            // 查询是否有相同的学生 id 如果有 则该学生已注册
            Students students = studentsService.selectStudentsByStudentId(register.getStudentID());
            if (students == null) {

                if (registerMapper.insertUser(register) == 1) {

                    /**
                     * user 表插入成功后 利用 username 的唯一性 获取到 User 对象 在以 user 的id 设置 学生的id 与
                     * 用户-角色 表的userid 相关连
                     * 防止查询用户权限时 查不到 该权限 与 该 学生 对象
                     */
                    User user = userService.selectUserByUsername(register.getUsername());
                    register.setUserId(user.getId());
                    register.setId(user.getId());

                    if (registerMapper.insertStudents(register) == 1) {

                        if (registerMapper.insertUserRole(register) == 1) {
                            return 1;
                        }
                    }
                }
            } else {
                // 判断用户中有没有该用户 如果没有再进行下一步
                if (userService.selectInfoById(students.getId()) == null) {
                    // 将已有学生的id插入
                    register.setUserId((long) students.getId());
                    if (registerMapper.insertUser(register) == 1) {
                        /**
                         * user 表插入成功后 利用 username 的唯一性 获取到 User 对象 在以 user 的id 设置 学生的id 与
                         * 用户-角色 表的userid 相关连
                         * 防止查询用户权限时 查不到 该权限 与 该 学生 对象
                         */
                        User user = userService.selectUserByUsername(register.getUsername());
                        register.setUserId(user.getId());
                        register.setId(user.getId());
                        if (registerMapper.insertUserRole(register) == 1) {
                            return 1;
                        }
                    }
                }
                return 2;
            }
        }
        return 0;
    }

    @Override
    public int insertTeachers(Register register) {
        // 查询是否有相同的用户名 如果有 则提示 该用户名已被注册
        if (userService.selectUserByUsername(register.getUsername()) == null) {

            // 查询是否有相同的教师 id 如果有 则提示 该教师已被注册
            if (teachersService.selectTeachersByTeacherId(register.getTeacherID()) == null) {

                if (registerMapper.insertUser(register) == 1) {

                    /**
                     * user 表插入成功后 利用 username 的唯一性 获取到 User 对象 在以 user 的id 设置 学生的id 与
                     * 用户-角色 表的userid 相关连
                     * 防止查询用户权限时 查不到 该权限 与 该 教师 对象
                     */
                    User user = userService.selectUserByUsername(register.getUsername());
                    register.setUserId(user.getId());
                    register.setId(user.getId());

                    if (registerMapper.insertTeachers(register) == 1) {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + register);
                        // 新增教师时顺便将教师单位也新增进去
                        Units units = new Units();
                        units.setUnitName(register.getDepartment());
                        units.setTeacherID(register.getTeacherID());
                        units.setPhone(register.getPhoneNumber());
                        units.setTeacherName(register.getName());
                        if (unitsService.insertUnits(units) == 1) {
                            if (registerMapper.insertUserRole(register) == 1) {
                                return 1;
                            }
                        }
                    }
                }
            }
            return 2;
        }
        return 0;
    }
}
