package com.xupt.service.impl;

import com.xupt.dao.ICategoryDao;
import com.xupt.domain.Category;
import com.xupt.domain.PageBean;
import com.xupt.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    public PageBean<Category> pageCategory(Integer currentPage) {
        if (currentPage <= 0){
            currentPage = 1;
        }
        int count = 9;
        PageBean<Category> pageBean = new PageBean<>();
        pageBean.setCurrentCount(count);
        //总条数
        int titleCount = categoryDao.findTitleCount();
        pageBean.setTotalCount(titleCount);
        //总页数
        int titlePages = (titleCount % count == 0) ? (titleCount / count): (titleCount / count + 1);
        if (titlePages == 0){
            titlePages = 1;
        }
        if (titlePages < currentPage){
            //如果当前页大于最后一页
            currentPage = titlePages;
        }
        pageBean.setTotalPage(titlePages);
        int start = (currentPage-1) * count;
        List<Category> users = categoryDao.findLimit(start, 9);
        pageBean.setList(users);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    public PageBean<Category> pageCategory(Integer currentPage, String cnameStr) {
        if (currentPage <= 0){
            currentPage = 1;
        }
        int count = 9;
        PageBean<Category> pageBean = new PageBean<>();
        pageBean.setCurrentCount(count);
        //总条数
        int titleCount = categoryDao.findTitleCountByStr(cnameStr);
        pageBean.setTotalCount(titleCount);
        //总页数
        int titlePages = (titleCount % count == 0) ? (titleCount / count): (titleCount / count + 1);
        if (titlePages == 0){
            titlePages = 1;
        }
        if (titlePages < currentPage){
            //如果当前页大于最后一页
            currentPage = titlePages;
        }
        pageBean.setTotalPage(titlePages);
        int start = (currentPage-1) * count;
        List<Category> categories = categoryDao.findByCnameLimit(cnameStr, start, 9);
        pageBean.setList(categories);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    public void delete(Integer cid) {
        categoryDao.delete(cid);
    }

    public void update(Category category) {
        categoryDao.update(category);
    }
}
