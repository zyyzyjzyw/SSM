package com.tedu.java.dao;

import com.tedu.java.pojo.Emp;

import java.util.List;

public interface EmpDao {
    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpGetEmpId(Integer empId);

    /**
     * 获取员工以及对应的部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDept(int empId);

    /**
     * 查询员工以及所对应的部门信息第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptStepOne(int empId);
    /**
     *
     */
    List<Emp> getDeptAndEmpStepTwo(int deptId);
}
