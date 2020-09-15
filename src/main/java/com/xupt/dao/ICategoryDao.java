package com.xupt.dao;

import com.xupt.domain.Category;
import com.xupt.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryDao {

    /**
     * 根据uid删除用户
     * @param cid
     */
    @Delete("delete from category where cid=#{cid}")
    void delete(Integer cid);

    /**
     * 修改用户
     * @param category
     */
    @Select("update category set sid=#{sid}, cname=#{cname} where cid=#{cid}")
    void update(Category category);

    /**
     * 计算总数
     * @return
     */
    @Select("select count(*) from category")
    Integer findTitleCount();

    /**
     * 分页查找全部Category
     * @param start
     * @param count
     * @return
     */
    @Select("select * from category limit #{start}, #{count}")
    List<Category> findLimit(@Param("start") Integer start, @Param("count") Integer count);

    /**
     * 计算包含cnameStr的总数
     * @param cnameStr
     * @return
     */
    @Select("select count(*) from category where cname like #{cnameStr}")
    Integer findTitleCountByStr(String cnameStr);

    /**
     * 根据cnameStr分页查找Category
     * @param cnameStr
     * @param start
     * @param count
     * @return
     */
    @Select("select * from category where cname like #{cnameStr} limit #{start}, #{count}")
    List<Category> findByCnameLimit(@Param("cnameStr") String cnameStr, @Param("start") Integer start, @Param("count") Integer count);
}
