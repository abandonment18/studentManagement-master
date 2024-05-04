package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.HomeMapper;
import com.gfxy.master.service.HomeService;
import com.gfxy.master.vo.EmploymentRankings;
import com.gfxy.master.vo.ProgrammingLanguageRankings;
import com.gfxy.master.vo.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<StudentCourse> selectCourseChooseNumber() {
        return homeMapper.selectCourseChooseNumber();
    }

    @Override
    public List<EmploymentRankings> selectEmploymentRankings() {
        return homeMapper.selectEmploymentRankings();
    }

    @Override
    public List<ProgrammingLanguageRankings> selectProgrammingLanguageRankings() {
        return homeMapper.selectProgrammingLanguageRankings();
    }
}
