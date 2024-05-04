package com.gfxy.master.service;

import com.gfxy.master.vo.User;

import java.util.List;

public interface UserService {


    // 查询登录时用户名和密码是否相同
    User selectUserByUsername(String username);


    User selectInfoById(int id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> selectUserList();

    /**
     * 查询所有用户
     *
     * @return
     */
    int deleteUserById(int id);

    /**
     * 修改用户  只能修改 email，phoneNumber，nickName，gender
     *
     * @param user
     * @return
     */
    int updateUser(User user);

}
