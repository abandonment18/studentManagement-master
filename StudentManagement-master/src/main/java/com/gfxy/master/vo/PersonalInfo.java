package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 个人信息字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo {

    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String UserName;
    /**
     * 昵称
     */
    private String NickName;
    /**
     * 密码
     */
    private String Password;
    /**
     * 账号状态（0正常 1停用）
     */
    private String Status;
    /**
     * 邮箱
     */
    private String Email;
    /**
     * 手机号
     */
    private String PhoneNumber;
    /**
     * 用户性别（0男，1女，2未知）
     */
    private String Gender;
    /**
     * 头像
     */
    private String Avatar;

    /**
     * 用户类型（0管理员，1普通用户）
     */
    private String userType;
    /**
     * 创建人的用户id
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Long updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private Integer delFlag;

    /**
     * 任课教师编号
     */
    private int TeacherID;
    /**
     * 姓名
     */
    private String Name;
    /**
     * 职称
     */
    private String Title;
    /**
     * 所在系
     */
    private String Department;

    /**
     * 学号
     */
    private int StudentID;

    /**
     * 年龄
     */
    private int Age;

}
