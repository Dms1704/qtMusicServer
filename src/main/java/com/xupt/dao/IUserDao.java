package com.xupt.dao;

import com.xupt.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    /**
     * 查所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据uid删除用户
     * @param uid
     */
    @Select("delete from user where uid=#{uid}")
    void delete(Integer uid);

    /**
     * 修改用户
     * @param user
     */
    @Select("update user set username=#{username}, password=#{password}, sex=#{sex}, address=#{address} where uid=#{uid}")
    void update(User user);

    /**
     * 计算总数
     * @return
     */
    @Select("select count(*) from user")
    Integer findTitleCount();

    /**
     * 分页查找全部User
     * @param start
     * @param count
     * @return
     */
    @Select("select * from user limit #{start}, #{count}")
    List<User> findLimit(@Param("start") Integer start, @Param("count") Integer count);

    /**
     * 计算包含unameStr的总数
     * @param unameStr
     * @return
     */
    @Select("select count(*) from user where username like #{unameStr}")
    Integer findTitleCountByStr(String unameStr);

    /**
     * 根据unameStr分页查找User
     * @param unameStr
     * @param start
     * @param count
     * @return
     */
    @Select("select * from user where username like #{unameStr} limit #{start}, #{count}")
    List<User> findByUnameLimit(@Param("unameStr") String unameStr, @Param("start") Integer start, @Param("count") Integer count);
}
