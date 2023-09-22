package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生选课字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {

    /**
     * id
     */
    private int id;
    /**
     * 学号
     */
    private int StudentID;
    /**
     * 课程表
     */
    private int CourseID;
    /**
     * 学生姓名
     */
    private String StudentName;
    /**
     * 课程名
     */
    private String CourseName;
    /**
     * 课程成绩
     */
    private int CourseGrade;


    /**
     * 学生选课信息查询后的统计数量
     */
    private int Number;
}
