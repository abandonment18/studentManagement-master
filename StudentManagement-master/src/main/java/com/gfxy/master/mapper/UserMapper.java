package com.gfxy.master.mapper;

import com.gfxy.master.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    // 登陆时查询密码和账号
    User selectUserByUsername(String username);

    User selectInfoById(int id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> selectAllUser();

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
