package com.tedu.java;

import com.tedu.java.dao.DeptDao;
import com.tedu.java.dao.EmpDao;
import com.tedu.java.pojo.Dept;
import com.tedu.java.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestResultMap {
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
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.getEmpGetEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.getEmpAndDept(1);
        System.out.println(emp);
    }
    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.getEmpAndDeptStepOne(1);
        System.out.println(emp);
    }
    @Test
    public void test4() throws IOException {
        SqlSession sqlSession = getSqlSession();
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        Dept deptAndEmpByDeptId = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(deptAndEmpByDeptId);
    }
    @Test
    public void test5() throws IOException {
        SqlSession sqlSession = getSqlSession();
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        Dept deptAndEmpByDeptId = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(deptAndEmpByDeptId.getDeptName());
    }
}
