package com.xupt.service.impl;

import com.xupt.dao.IDiscussDao;
import com.xupt.dao.IUserDao;
import com.xupt.domain.Discuss;
import com.xupt.domain.PageBean;
import com.xupt.domain.User;
import com.xupt.service.IDiscussService;
import com.xupt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussService implements IDiscussService {

    @Autowired
    private IDiscussDao discussDao;

    public PageBean<Discuss> pageDiscuss(Integer currentPage) {
        if (currentPage <= 0){
            currentPage = 1;
        }
        int count = 9;
        PageBean<Discuss> pageBean = new PageBean<>();
        pageBean.setCurrentCount(count);
        //总条数
        int titleCount = discussDao.findTitleCount();
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
        List<Discuss> discusses = discussDao.findLimit(start, 9);
        pageBean.setList(discusses);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    public PageBean<Discuss> pageDiscuss(Integer currentPage, String describeStr) {
        if (currentPage <= 0){
            currentPage = 1;
        }
        int count = 9;
        PageBean<Discuss> pageBean = new PageBean<>();
        pageBean.setCurrentCount(count);
        //总条数
        int titleCount = discussDao.findTitleCountByStr(describeStr);
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
        List<Discuss> discusses = discussDao.findByDescribeLimit("%"+describeStr+"%", start, 9);
        pageBean.setList(discusses);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    public void delete(Integer did) {
        discussDao.delete(did);
    }

    public void update(Discuss discuss) {
        discussDao.update(discuss);
    }
}
