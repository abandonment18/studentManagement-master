package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教师授课字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCourse {

    /**
     * id
     */
    private int id;
    /**
     * 教师号
     */
    private int TeacherID;
    /**
     * 所授课程号
     */
    private int CourseID;
    /**
     * 教师姓名
     */
    private String TeacherName;
    /**
     * 所选课程名
     */
    private String CourseName;
    /**
     * 所授课程分
     */
    private int CourseCredit;
}
