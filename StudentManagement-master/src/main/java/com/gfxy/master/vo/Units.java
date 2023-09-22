package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教师单位字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Units {
    /**
     * id
     */
    private int id;
    /**
     * 单位名称
     */
    private String UnitName;
    /**
     * 电话
     */
    private String Phone;
    /**
     * 教师号
     */
    private int TeacherID;
    /**
     * 教师姓名
     */
    private String TeacherName;
}
