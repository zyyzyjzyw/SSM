package com.tedu.java.dao;

import com.tedu.java.pojo.Dept;

public interface DeptDao {

    Dept getEmpDeptByStepTwo(int deptId);

    /**
     * 查询部门以及部门中的员工信息
     * @param depId
     * @return
     */
    Dept getDeptAndEmpByDeptId(int depId);

    /**
     * 通过分步查询查询部门以及部门中的员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(int deptId);
}
