package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教师字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teachers {
    /**
     * id
     */
    private int id;

    /**
     * 任课教师编号
     */
    private int TeacherID;
    /**
     * 姓名
     */
    private String Name;
    /**
     * 性别
     */
    private String Gender;
    /**
     * 职称
     */
    private String Title;
    /**
     * 所在系
     */
    private String Department;
}
