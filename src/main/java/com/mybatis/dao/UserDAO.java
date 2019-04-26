package com.mybatis.dao;

import com.mybatis.entity.User;

import java.util.List;

public interface UserDAO {
    public User findUserById(Integer id);

    public List<User> findUserByName(String username);

    public void insertUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);
}
