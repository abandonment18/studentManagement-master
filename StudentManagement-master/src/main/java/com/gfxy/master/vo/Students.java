package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    /**
     * 主键 id
     */
    private int id;

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

}
