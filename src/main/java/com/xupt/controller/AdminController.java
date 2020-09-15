package com.xupt.controller;

import com.alibaba.fastjson.JSON;
import com.xupt.domain.Admin;
import com.xupt.domain.User;
import com.xupt.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping("/admin/listAdmin")
    public String listAdmin(Model model){
        List<Admin> admins = adminService.findAll();
        model.addAttribute("adminList", admins);
        return "adminList";
    }

    @RequestMapping("/admin/update")
    public String update(Admin admin){
        adminService.update(admin);
        return "redirect:listAdmin";
    }

    @RequestMapping("/admin/delete")
    public String delete(Integer id){
        adminService.delete(id);
        return "redirect:listAdmin";
    }

    @RequestMapping("/admin/recordAdmin")
    public String recordUser(Admin admin, Model model){
        model.addAttribute("updateAdmin", admin);
        return "adminUpdate";
    }

    @RequestMapping("/login")
    public void Login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String admin_name = request.getParameter("admin_name");
        String admin_password = request.getParameter("admin_password");
        Admin login = adminService.Login(admin_name, admin_password);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(login!=null){
            hashMap.put("success",true);
        }else{
            hashMap.put("success",false);
        }
        System.out.println(JSON.toJSONString(hashMap));
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
}
