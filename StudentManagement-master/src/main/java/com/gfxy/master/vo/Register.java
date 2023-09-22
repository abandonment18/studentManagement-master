package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注册 教师 与 学生 字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    /**
     * id
     */
    private Long id;

    /**
     * 学号
     */
    private int StudentID;

    /**
     * 所在院系
     */
    private String Department;

    /**
     * 姓名
     */
    private String Name;

    /**
     * 性别
     */
    private String Gender;

    /**
     * 年龄
     */
    private int Age;

    /**
     * 任课教师编号
     */
    private int TeacherID;
    /**
     * 职称
     */
    private String Title;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型（0 教师，1 学生）
     */
    private String userType;

    /**
     * 用户 id
     */
    private Long UserId;

    /**
     * 角色 id
     */
    private int RoleId;
}
