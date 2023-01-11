package com.tedu.java;

import com.tedu.java.dao.EmpMapper;
import com.tedu.java.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDynamicSql {
    public SqlSession getSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        return sqlSession;
    }

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp(null,null,20,"男");
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        System.out.println(empByCondition);
    }

    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = mapper.getEmpListWithWhere(new Emp(null, null, 20, "男"));
        System.out.println(empList);

    }

    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = mapper.getEmplistWithTrim(new Emp(null, null, 20, "男"));
        System.out.println(empList);
    }

    @Test
    public void test4() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = mapper.getEmpListWithChoose(new Emp(null, null, 20, "男"));
        System.out.println(empList);
    }

    @Test
    public void test5() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = new ArrayList<Emp>();
        Emp emp1 = new Emp(null, "zyw", 20, "男");
        Emp emp2 = new Emp(null, "zml", 45, "男");
        Emp emp3 = new Emp(null, "lhl", 40, "女");
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        int count = mapper.insertEmpForeach(empList);
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void test6() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int[] empIds = new int[]{5,6,7};
        int count = mapper.deleteEmpForeach(empIds);
        System.out.println(count);
        sqlSession.close();
    }
    @Test
    public void test7() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int[] empIds = new int[]{1,2,3,4};
        int count = mapper.deleteEmpForeachByArray(empIds);
        System.out.println(count);
        sqlSession.close();
    }
    @Test
    public void test8() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = mapper.getEmpList();
        List<Emp> empList2 = mapper.getEmpList();
        System.out.println(empList);
        System.out.println(empList2);
        sqlSession.close();
    }
}
