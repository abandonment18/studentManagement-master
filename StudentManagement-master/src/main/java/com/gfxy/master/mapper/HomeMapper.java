package com.gfxy.master.mapper;

import com.gfxy.master.vo.EmploymentRankings;
import com.gfxy.master.vo.ProgrammingLanguageRankings;
import com.gfxy.master.vo.StudentCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
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
