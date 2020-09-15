package com.xupt.controller;

import com.xupt.domain.Category;
import com.xupt.domain.PageBean;
import com.xupt.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/listCategory")
    public String listCategorys(Integer currentPage, Model model){
        PageBean<Category> categoryPageBean = categoryService.pageCategory(currentPage);
        model.addAttribute("categoryPageBean", categoryPageBean);
        model.addAttribute("isQuery", true);
        return "categoryList";
    }

    @RequestMapping("/delete")
    public String deleteCategory(Integer cid){
        categoryService.delete(cid);
        return "redirect:listCategory?currentPage=1";
    }

    @RequestMapping("/update")
    public String updateCategory(Category category){
        categoryService.update(category);
        return "redirect:listCategory?currentPage=1";
    }

    @RequestMapping("/recordCategory")
    public String recordUser(Category category, Model model){
        model.addAttribute("updateCategory", category);
        return "categoryUpdate";
    }

    @RequestMapping("/search")
    public String searchPage(Integer currentPage, String cnameStr, Model model){
        PageBean<Category> categoryPageBean = categoryService.pageCategory(currentPage, cnameStr);
        model.addAttribute("categoryPageBean", categoryPageBean);
        model.addAttribute("isQuery", true);
        model.addAttribute("queryStr", cnameStr);
        return "categoryList";
    }
}
