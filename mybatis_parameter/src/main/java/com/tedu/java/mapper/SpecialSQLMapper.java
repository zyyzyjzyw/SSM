package com.tedu.java.mapper;

import com.tedu.java.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    /**
     * 通过用户名模糊查询
     * @param moHu
     * @return
     */
    List<User> getUserByLike(@Param("moHu") String moHu);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态设置表名
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户信息,并获取主键
     * @param user
     */
    void insertUser(User user);
}
