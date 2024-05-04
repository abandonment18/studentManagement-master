package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.UserMapper;
import com.gfxy.master.service.UserService;
import com.gfxy.master.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public User selectInfoById(int id) {
        return userMapper.selectInfoById(id);
    }

    @Override
    public List<User> selectUserList() {
        return userMapper.selectAllUser();
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }


}
