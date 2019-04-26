package com.mybatis.dao;

import com.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.InputStream;
import java.util.List;

public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;

    @BeforeTest
    public void setUp() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserByIdTest(){
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByNameTest(){
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> list = userDao.findUserByName("小");
        System.out.println(list);
    }

}
