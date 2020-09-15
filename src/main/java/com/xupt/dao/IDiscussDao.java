package com.xupt.dao;

import com.xupt.domain.Discuss;
import com.xupt.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiscussDao {

    /**
     * 根据did删除评论
     * @param did
     */
    @Delete("delete from discuss where did=#{did}")
    void delete(Integer did);

    /**
     * 修改评论
     * @param discuss
     */
    @Update("update discuss set uid=#{uid}, dtime=#{dtime}, `describe`=#{describe}, sid=#{sid} where did=#{did}")
    void update(Discuss discuss);

    /**
     * 计算总数
     * @return
     */
    @Select("select count(*) from discuss")
    Integer findTitleCount();

    /**
     * 分页查找全部Discuss
     * @param start
     * @param count
     * @return
     */
    @Select("select * from discuss limit #{start}, #{count}")
    List<Discuss> findLimit(@Param("start") Integer start, @Param("count") Integer count);

    /**
     * 计算包含desctibeStr的总数
     * @param describeStr
     * @return
     */
    @Select("select count(*) from discuss where `describe` like #{describeStr}")
    Integer findTitleCountByStr(String describeStr);

    /**
     * 根据describeStr分页查找User
     * @param describeStr
     * @param start
     * @param count
     * @return
     */
    @Select("select * from discuss where `describe` like #{describeStr} limit #{start}, #{count}")
    List<Discuss> findByDescribeLimit(@Param("describeStr") String describeStr, @Param("start") Integer start, @Param("count") Integer count);
}
