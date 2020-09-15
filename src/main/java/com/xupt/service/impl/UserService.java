package com.xupt.service.impl;

import com.xupt.dao.IAdminDao;
import com.xupt.dao.IUserDao;
import com.xupt.domain.Admin;
import com.xupt.domain.PageBean;
import com.xupt.domain.User;
import com.xupt.service.IAdminService;
import com.xupt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public PageBean<User> pageUser(Integer currentPage) {
        if (currentPage <= 0){
            currentPage = 1;
        }
        int count = 9;
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentCount(count);
        //总条数
        int titleCount = userDao.findTitleCount();
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
        List<User> users = userDao.findLimit(start, 9);
        pageBean.setList(users);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    public PageBean<User> pageUser(Integer currentPage, String unameStr) {
        if (currentPage <= 0){
            currentPage = 1;
        }
        int count = 9;
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentCount(count);
        //总条数
        int titleCount = userDao.findTitleCountByStr(unameStr);
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
        List<User> users = userDao.findByUnameLimit("%"+unameStr+"%", start, 9);
        pageBean.setList(users);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    public void delete(Integer uid) {
        userDao.delete(uid);
    }

    public void update(User user) {
        userDao.update(user);
    }
}
