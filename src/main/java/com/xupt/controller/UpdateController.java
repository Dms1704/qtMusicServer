package com.xupt.controller;

import com.alibaba.fastjson.JSON;
import com.xupt.domain.Song;
import com.xupt.service.IUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Update")
public class UpdateController {
    @Autowired
    private IUpdateService updateService;
    /*更新歌曲-获取所有歌曲数据*/
    @RequestMapping("/SelectSong")
    public void UpdateSong(HttpServletResponse response) throws IOException {
        List<Song> list = updateService.UpdateSong();
        response.setContentType("application/json;charset=utf-8");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data",list);
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
    /*更新歌曲-修改歌曲数据*/
    @RequestMapping("/InsertSong")
    @ResponseBody
    public void InsertSong(@RequestParam("arr") String arr[], HttpServletRequest request){
        for (int i = 0; i < arr.length; i++) {
            String sid = arr[i].split("_")[0];
            String song_url=arr[i].split("_")[1];
            updateService.InsertSong(Integer.parseInt(sid),song_url);
        }
    }
    /*更新mv-获取所有mv数据*/
    @RequestMapping("/SelectMv")
    public void UpdateMv(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Song> list = updateService.SelectMv();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data",list);
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
    /*更新——修改mv数据*/
    @RequestMapping("/InsertMv")
    @ResponseBody
    public void InsertMv(@RequestParam("arr") String arr[], HttpServletRequest request){
        for (int i = 0; i < arr.length; i++) {
            String sid = arr[i].split("_")[0];
            String mv_url=arr[i].split("_")[1];
            updateService.InsertMv(Integer.parseInt(sid),mv_url);
        }
    }
}
