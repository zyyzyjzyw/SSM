package com.tedu.java;

import com.tedu.java.mapper.UserMapper;
import com.tedu.java.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： zyy
 * @date： 2023/2/4 13:34
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
public class ParameterTest {
    public SqlSession getSqlSession() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        return sqlSession;
    }

    @Test
    public void testGetUserByUSerName() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.getUserByUsername("admin");
        System.out.println(admin);
        sqlSession.close();
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.checkLogin("admin", "1235456");
        System.out.println(admin);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "1235456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.checkLoginByParam("admin", "1235456");
        System.out.println(admin);
        sqlSession.close();
    }
    @Test
    public void testUserByIdToMap() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(1);
        // {password=1235456, gender=男, id=1, age=23, email=471321885@qq.com, username=admin}
        System.out.println(userByIdToMap);
        sqlSession.close();
    }
    @Test
    public void testAllUserToMap() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        /*List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);*/
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
        sqlSession.close();
    }
}
