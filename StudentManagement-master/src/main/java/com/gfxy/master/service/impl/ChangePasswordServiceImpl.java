package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.ChangePasswordMapper;
import com.gfxy.master.service.ChangePasswordService;
import com.gfxy.master.service.UserService;
import com.gfxy.master.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChangePasswordServiceImpl implements ChangePasswordService {

    @Autowired
    private ChangePasswordMapper changePasswordMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int updatePassword(User user) {
        // 根据用户名查询到 user 对象 获取
        User user1 = userService.selectUserByUsername(user.getUsername());

        // 判断输入的 旧密码 是否与 数据库中的密码相同
        if (passwordEncoder.matches(user.getOldPassword(), user1.getPassword())) {

            // 判断 新密码 是否与 数据库中的密码相同
            if (!passwordEncoder.matches(user.getPassword(), user1.getPassword())) {

                user.setId(user1.getId());
                // 密码加密
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                return changePasswordMapper.updatePassword(user);
            }
            return 2;
        }
        return 0;
    }
}
