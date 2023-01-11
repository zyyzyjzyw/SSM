package com.tedu.java.dao;

import com.tedu.java.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 根据条件查询emp信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);
    /**
     * where动态条件查询
     */
    List<Emp> getEmpListWithWhere(Emp emp);
    /**
     * trim动态条件查询
     */
    List<Emp> getEmplistWithTrim(Emp emp);
    /**
     * choose/when/otherwise动态SQL查询
     */
    List<Emp> getEmpListWithChoose(Emp emp);

    int insertEmpForeach(@Param("empList") List<Emp> empList);
    int deleteEmpForeach(@Param("empIds") int[] empIds);
    int deleteEmpForeachByArray(@Param("empIds") int[] empIds);

    List<Emp> getEmpList();

}
