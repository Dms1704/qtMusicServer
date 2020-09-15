package com.xupt.controller;

import com.alibaba.fastjson.JSON;
import com.xupt.domain.Song;
import com.xupt.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Upload")
public class UploadController {
    @Autowired
    private IUploadService songService;
    /*歌曲上传*/
    @RequestMapping("/Upload")
    public void SongUpload(@ModelAttribute Song song, HttpServletResponse response) throws IOException {
        System.out.println(song);
        response.setContentType("application/json;charset=utf-8");
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            int i = songService.SongUpload(song);
            hashMap.put("success",true);
        } catch (Exception e) {
           hashMap.put("success",false);
           hashMap.put("msg",e.getMessage());
        }
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
    /*歌曲播放量初始化*/
    @RequestMapping("/SongPlayNum")
    public void SongPlayNum(HttpServletRequest request){
        String sid = request.getParameter("sid");
        songService.SongPlayNum(Integer.parseInt(sid));
    }
    /*查询歌曲列表中有mv的歌曲并且mv资源未被上传*/
    @RequestMapping("/SelectMv")
    public void SelectMv(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Song> list = songService.MvSelect();
        HashMap<String, Object> hashMap = new HashMap<>();
        if (list!=null){
            hashMap.put("success",true);
            hashMap.put("datas",list);
        } else {
            hashMap.put("success",false);
            hashMap.put("datas","无数据");
        }
        System.out.println(JSON.toJSONString(hashMap));
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
    /*上传mv资源*/
    @RequestMapping("/Mv")
    public void SongUpload(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String sid = request.getParameter("sid");
        String mv_url = request.getParameter("mv_url");
        //添加之前需要先验证数据库中有没有相同的资源
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Integer> integers = songService.SelectMid(Integer.parseInt(sid));
        if(integers==null||integers.size()==0){
            int i = songService.MvUpload(Integer.parseInt(sid), mv_url);
            hashMap.put("success",true);
        }else{
            hashMap.put("success",false);
            hashMap.put("msg","Mv资源已存在");
        }
        System.out.println(JSON.toJSONString(hashMap));
        response.getWriter().print(JSON.toJSONString(hashMap));
    }
    @RequestMapping("/MvPlayNum")
    public void MvPlayNum(HttpServletRequest request){
        String sid = request.getParameter("sid");
        List<Integer> integers = songService.SelectMid(Integer.parseInt(sid));
        int i = songService.MvPlayNum(integers.get(0));
    }
}
