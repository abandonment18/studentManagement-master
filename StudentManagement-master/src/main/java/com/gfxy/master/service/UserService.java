package com.gfxy.master.service;

import com.gfxy.master.vo.User;

public interface UserService {


    // 查询登录时用户名和密码是否相同
    User selectUserByUsername(String username);
    

}
