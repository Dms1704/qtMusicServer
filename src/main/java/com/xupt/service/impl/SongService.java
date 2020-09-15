package com.xupt.service.impl;

import com.xupt.dao.ISongDao;
import com.xupt.domain.Song;
import com.xupt.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongDao songDao;
    @Override
    public List<Song> SelectAll() {
        return songDao.SelectAll();
    }

    @Override
    public int DeleteSong(int sid) {
        int i;
        try {
           i= songDao.DeleteSong(sid);
        } catch (Exception e) {
           throw new RuntimeException("下架失败");
        }
        return i;
    }
}
