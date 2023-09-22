package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程表字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {


    /**
     * id
     */
    private int id;
    /**
     * 课程编号
     */
    private int CourseID;
    /**
     * 课程名称
     */
    private String CourseName;
    /**
     * 任课单位
     */
    private String DepartmentOffering;
    /**
     * 任课教师编号
     */
    private int TeacherID;

}
