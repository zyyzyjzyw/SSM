package com.tedu.java.mapper;

import com.tedu.java.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * mybatis获取参数值的两种方式:#{}和${}。
 * #{}的本质是占位符赋值,${}的本质是字符串拼接。
 * 1.若mapper接口中放法的参数为单个字面量类型,此时可以通过任意的内容获取参数值,一定要注意${}的单引号要自己添加.
 * 2.若mapper接口中方法的参数为多个字面量类型,此时mybatis会将参数放在map集合里,以两种方式存储数据:
 * a. 以arg0,arg1...为键,以参数为值。
 * b. 以param1,param2...为键,以参数为值
 * 因此,只需要通过#{}和${}访问map集合中的key，就可以获取响应的值,但一定要注意${}中单引号的问题。
 * 3. 若mapper接口方法的参数为map集合类型的值，此时可以手动创建map集合，将这些数据放在
 * map中只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号。
 * 4. 若mapper接口的方法的参数为实体类型的参数
 * 只需要将实体类中的相对应的属性值,一定要注意${}中单引号的问题。
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User getUserByUsername(String userName);
    User checkLogin(@Param("userName") String userName,@Param("password") String password);

    User checkLoginByMap(Map<String,Object> map);
    User checkLoginByParam(@Param("userName") String userName,@Param("password") String password);

    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
    //List<Map<String,Object>> getAllUserToMap();
    //

    /**
     * 若查询的数据有多条,并且要将每条数据转换为map集合
     * 此时有两种解决方案:
     * 1.将mapper接口方法的返回值设置为泛型是map的list集合
     * 2.将每条数据转换的map集合放在一个大的map中,但是必须要使用@MapKey
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();


}
