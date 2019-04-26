package com.mybatis.mapper;

import com.mybatis.entity.User;
import com.mybatis.entity.UserQueryVo;

import java.util.List;

public interface UserMapper {
    public User findUserById(Integer id);

    public List<User> findUserByName(String username);

    public void insertUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);

    public List<User> findUserList(UserQueryVo userQueryVo);
}
