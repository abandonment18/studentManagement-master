package com.gfxy.master.service;


import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
