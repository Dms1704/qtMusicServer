package com.xupt.service;

import com.xupt.domain.Discuss;
import com.xupt.domain.PageBean;
import com.xupt.domain.User;

import java.util.List;

public interface IDiscussService {

    /**
     * 分页查找Discuss
     * @param currentPage
     * @return
     */
    PageBean<Discuss> pageDiscuss(Integer currentPage);

    /**
     * 根据did删除用户
     * @param did
     */
    void delete(Integer did);

    /**
     * 修改Discuss
     * @param discuss
     */
    void update(Discuss discuss);
}
