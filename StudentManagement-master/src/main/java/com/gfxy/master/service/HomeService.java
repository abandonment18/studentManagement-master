package com.gfxy.master.service;

import com.gfxy.master.vo.StudentCourse;

import java.util.List;

public interface HomeService {

    /**
     * 在展示页 展示学生的选课信息并统计
     *
     * @return
     */
    List<StudentCourse> selectCourseChooseNumber();

}
