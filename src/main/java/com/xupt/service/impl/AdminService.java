package com.xupt.service.impl;

import com.xupt.dao.IAdminDao;
import com.xupt.domain.Admin;
import com.xupt.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("adminService")
public class AdminService implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    public void update(Admin admin) {
        adminDao.update(admin);
    }

    public void delete(Integer id) {
        adminDao.delete(id);
    }

    @Override
    public Admin Login(String admin_name, String admin_password) {
        return adminDao.Login(admin_name,admin_password);
    }
}
