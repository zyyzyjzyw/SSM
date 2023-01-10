package com.tedu.java;

import com.tedu.java.dao.UserMapper;
import com.tedu.java.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    public SqlSession getSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        return sqlSession;
    }
    /**
     * 新增
     * @throws IOException
     */
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.insertUser();
        System.out.println(count);
        sqlSession.close();
    }
    /**
     * 删除
     */
    @Test
    public void testDelete() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetUserList() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
    }

    @Test
    public void testGetUserByParamId() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser(1);
        System.out.println(user);

    }

    @Test
    public void testCount() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
    }
    @Test
    public void testGetUserToMap() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> userToMap = mapper.getUserToMap(1);
        System.out.println(userToMap);
    }

    @Test
    public void testGetAllUserToMap() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
        System.out.println(allUserToMap.get(0).get("id"));
    }

    @Test
    public void testSelectUserDim() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserDim("y");
        System.out.println(users);
    }

    @Test
    public void testInsertUserGenera() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.insertUserGenera(new User(null, "zyj", "123456", 23, "女", "zyj@qq.com"));
        System.out.println(row);
    }


}
