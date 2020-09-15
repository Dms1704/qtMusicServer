package com.xupt.controller;

import com.alibaba.fastjson.JSON;
import com.xupt.domain.Song;
import com.xupt.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Delete")
/*歌曲下架*/
public class SongController {
    @Autowired
    private ISongService songService;
    @RequestMapping("/SelectAll")
    public void SelectAll(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Song> list = songService.SelectAll();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("datas",list);
        System.out.println(JSON.toJSONString(hashMap));
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
    @RequestMapping("/DeleteSong")
    public void DeleteSong(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String sid = request.getParameter("sid");
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            int i = songService.DeleteSong(Integer.parseInt(sid));
            hashMap.put("success",true);
        } catch (Exception e) {
            hashMap.put("success",false);
            hashMap.put("msg",e.getMessage());
        }
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
}
