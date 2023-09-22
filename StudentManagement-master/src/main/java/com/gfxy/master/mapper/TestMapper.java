package com.gfxy.master.mapper;

import com.gfxy.master.vo.Teachers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    int insertTeachers(Teachers teachers);

    int updateTeachers(Teachers teachers);
}
