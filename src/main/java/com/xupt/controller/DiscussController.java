package com.xupt.controller;

import com.xupt.domain.Discuss;
import com.xupt.domain.PageBean;
import com.xupt.domain.User;
import com.xupt.service.impl.DiscussService;
import com.xupt.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    @RequestMapping("/listDiscuss")
    public String listDiscusss(Integer currentPage, Model model){
        PageBean<Discuss> discussPageBean = discussService.pageDiscuss(currentPage);
        model.addAttribute("discussPageBean", discussPageBean);
        model.addAttribute("isQuery", true);
        return "discussList";
    }

    @RequestMapping("/delete")
    public String deleteDiscuss(Integer did){
        discussService.delete(did);
        return "redirect:listDiscuss?currentPage=1";
    }

    @RequestMapping("/update")
    public String updateDiscuss(Discuss discuss){
        discussService.update(discuss);
        return "redirect:listDiscuss?currentPage=1";
    }

    @RequestMapping("/recordDiscuss")
    public String recordDiscuss(Discuss discuss, Model model){
        model.addAttribute("updateDiscuss", discuss);
        return "discussUpdate";
    }

    @RequestMapping("/search")
    public String searchPage(Integer currentPage, String describeStr, Model model){
        PageBean<Discuss> discussPageBean = discussService.pageDiscuss(currentPage, describeStr);
        model.addAttribute("discussPageBean", discussPageBean);
        model.addAttribute("isQuery", true);
        model.addAttribute("queryStr", describeStr);
        return "discussList";
    }
}
