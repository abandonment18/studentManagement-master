package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.HomeMapper;
import com.gfxy.master.service.HomeService;
import com.gfxy.master.vo.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;
    
    @Override
    public List<StudentCourse> selectCourseChooseNumber() {
        return homeMapper.selectCourseChooseNumber();
    }
}
