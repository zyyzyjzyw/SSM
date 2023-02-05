package com.tedu.java;

import com.tedu.java.mapper.SpecialSQLMapper;
import com.tedu.java.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author： zyy
 * @date： 2023/2/5 10:11
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
public class SpecialSQLMapperTest {
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
    public void testGetUserByLike(){
        SqlSession sqlSession = getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::print);
        sqlSession.close();
    }
    @Test
    public void testdeleteMoreUser(){
        SqlSession sqlSession = getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("10,11,12,13,14");
        sqlSession.close();
    }
    @Test
    public void testGetUserList(){
        SqlSession sqlSession = getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::print);
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "zyy", "123456", 23, "男", "471321885@qq.com");
        mapper.insertUser(user);
        System.out.println(user);

    }
}
