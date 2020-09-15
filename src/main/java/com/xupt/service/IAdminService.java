package com.xupt.service;


import com.xupt.domain.Admin;

import java.util.List;

public interface IAdminService {

    /**
     * 查所有
     * @return
     */
    List<Admin> findAll();

    /**
     * 修改
     * @return
     */
    void update(Admin admin);

    /**
     * 删除
     * @return
     */
    void delete(Integer id);

    Admin Login(String admin_name, String admin_password);
}
