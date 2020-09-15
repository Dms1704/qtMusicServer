package com.xupt.dao;

import com.xupt.domain.Admin;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminDao {

    /**
     * 查所有
     * @return
     */
    @Select("select * from admin")
    List<Admin> findAll();

    /**
     * 修改
     * @param admin
     */
    @Select("update admin set admin_name=#{admin_name}, admin_password=#{admin_password} where id=#{id}")
    void update(Admin admin);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from admin where id=#{id}")
    void delete(Integer id);

    @Select("select * from admin where admin_name = #{admin_name} and admin_password=#{admin_password}")
    public Admin Login(@Param("admin_name") String admin_name,@Param("admin_password") String admin_password);
}
