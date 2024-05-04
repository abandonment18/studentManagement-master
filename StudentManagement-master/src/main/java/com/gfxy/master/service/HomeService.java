package com.gfxy.master.service;

import com.gfxy.master.vo.EmploymentRankings;
import com.gfxy.master.vo.ProgrammingLanguageRankings;
import com.gfxy.master.vo.StudentCourse;

import java.util.List;

public interface HomeService {

    /**
     * 在展示页 展示学生的选课信息并统计
     *
     * @return
     */
    List<StudentCourse> selectCourseChooseNumber();

    /**
     * 在展示页 展示专业排名
     *
     * @return
     */
    List<EmploymentRankings> selectEmploymentRankings();


    /**
     * 在展示页 展示编程语言排名
     *
     * @return
     */
    List<ProgrammingLanguageRankings> selectProgrammingLanguageRankings();

}
