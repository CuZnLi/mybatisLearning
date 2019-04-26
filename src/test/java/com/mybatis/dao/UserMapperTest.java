package com.mybatis.dao;

import com.mybatis.entity.User;
import com.mybatis.entity.UserQueryVo;
import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @BeforeTest
    public void setUp() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testFindUserList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setUsername("小");
        user.setSex("1");
        userQueryVo.setUser(user);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findUserList(userQueryVo);
        for (User user1:list){
            System.out.println(user1);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
