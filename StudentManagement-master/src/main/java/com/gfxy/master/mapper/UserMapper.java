package com.gfxy.master.mapper;

import com.gfxy.master.vo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    // 登陆时查询密码和账号
    User selectUserByUsername(String username);
    

}
