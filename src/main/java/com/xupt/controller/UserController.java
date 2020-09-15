package com.xupt.controller;

import com.xupt.domain.PageBean;
import com.xupt.domain.User;
import com.xupt.service.IUserService;
import com.xupt.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/listUser")
    public String listUsers(Integer currentPage, Model model){
        PageBean<User> userPageBean = userService.pageUser(currentPage);
        model.addAttribute("userPageBean", userPageBean);
        model.addAttribute("isQuery", true);
        return "userList";
    }

    @RequestMapping("/delete")
    public String deleteUser(Integer uid){
        userService.delete(uid);
        return "redirect:listUser?currentPage=1";
    }

    @RequestMapping("/update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:listUser?currentPage=1";
    }

    @RequestMapping("/recordUser")
    public String recordUser(User user, Model model){
        model.addAttribute("updateUser", user);
        return "userUpdate";
    }

    @RequestMapping("/search")
    public String searchPage(Integer currentPage, String unameStr, Model model){
        PageBean<User> userPageBean = userService.pageUser(currentPage, unameStr);
        model.addAttribute("userPageBean", userPageBean);
        model.addAttribute("isQuery", true);
        model.addAttribute("queryStr", unameStr);
        return "userList";
    }
}
