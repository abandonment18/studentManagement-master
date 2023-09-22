package com.gfxy.master.mapper;

import com.gfxy.master.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChangePasswordMapper {

    int updatePassword(User user);
}
