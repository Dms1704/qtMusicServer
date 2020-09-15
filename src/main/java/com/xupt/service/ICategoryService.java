package com.xupt.service;

import com.xupt.domain.Category;
import com.xupt.domain.PageBean;

public interface ICategoryService {

    /**
     * 分页查找Category
     * @param currentPage
     * @return
     */
    PageBean<Category> pageCategory(Integer currentPage);

    /**
     * 根据cid删除用户
     * @param cid
     */
    void delete(Integer cid);

    /**
     * 修改User
     * @param category
     */
    void update(Category category);
}
