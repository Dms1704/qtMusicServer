package com.xupt.service;

import com.xupt.domain.PageBean;
import com.xupt.domain.User;

import java.util.List;

public interface IUserService {

    /**
     * 查所有
     * @return
     */
    List<User> findAll();

    /**
     * 分页查找User
     * @param currentPage
     * @return
     */
    PageBean<User> pageUser(Integer currentPage);

    /**
     * 根据uid删除用户
     * @param uid
     */
    void delete(Integer uid);

    /**
     * 修改User
     * @param user
     */
    void update(User user);
}
