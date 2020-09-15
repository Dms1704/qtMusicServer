package com.xupt.service.impl;

import com.xupt.dao.IUploadDao;
import com.xupt.domain.Song;
import com.xupt.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadService implements IUploadService {
    @Autowired
    private IUploadDao songDao;

    @Override
    public int SongUpload(Song song) {
        int i;
        System.out.println(song);
        try {
            if(song.getUrl()==null){
                throw new RuntimeException("歌曲已存在或当前歌曲资源不存在");
            }
            i = songDao.SongUpload(song);
            System.out.println(i);
        } catch (Exception e) {
            throw new RuntimeException("歌曲已存在或当前歌曲资源不存在");
        }
        return i;
    }

    @Override
    public int SongPlayNum(int sid) {
        return songDao.SongPlayNum(sid);
    }

    @Override
    public int MvUpload(int sid, String mv_url) {
        return songDao.MvUpload(sid,mv_url);
    }

    @Override
    public List<Song> MvSelect() {
        return songDao.MvSelect();
    }

    @Override
    public List<Integer> SelectMid(int sid) {
        return songDao.SelectMid(sid);
    }

    @Override
    public int MvPlayNum(int mid) {
        return songDao.MvPlayNum(mid);
    }


}
