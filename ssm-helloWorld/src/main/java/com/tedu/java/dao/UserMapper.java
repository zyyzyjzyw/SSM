package com.tedu.java.dao;

import com.tedu.java.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 添加用户信息
     * @return
     */
    int insertUser();
    /**
     * 删除用户信息根据id
     */
    void deleteUser();
    /**
     * 修改用户信息
     */
    void updateUser();
    /**
     * 查询一个实体类对象
     */
    User getUserById();
    /**
     * 查询list集合
     */
    List<User> getUserList();
    /**
     * 根据用户id查询用户信息
     */
    User getUser(@Param("id") int id);
    /**
     * 查询用户的总记录数
     * 在mybatis中,对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer->int|integer
     * 例如:int-->_int|_integer
     * 例如:Map-->map,List-->list
     */
    int getCount();
    /**
     * 根据用户id查询用户信息为map集合
     */
    @MapKey("id")
    Map<String,Object> getUserToMap(@Param("id") int id);
    /**
     * 查询所有用户信息为map集合
     * 将表中的数据以map集合的方式查询,一条数据对应一个map;若有多条数据,
     * 就会产生多个map集合,此时可以将这些map放到一个集合里面。
     */
    @MapKey("id")
    List<Map<String,Object>> getAllUserToMap();
    /**
     * 模糊查询
     */
    List<User> getUserDim(@Param("username") String username);
    /**
     * 添加用户信息
     * useGeneratedKeys:设置使用的自增主键
     * keyProperty:因为增删改有统一的返回值是受影响的行数,因此只能将获取的自增的主键放
     * 在传送的参数user对象的某个属性中。
     */
    int insertUserGenera(User user);
}
