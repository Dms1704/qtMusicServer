package com.xupt.service.impl;

import com.xupt.dao.IUpdateDao;
import com.xupt.domain.Song;
import com.xupt.service.IUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateService implements IUpdateService {
    @Autowired
    private IUpdateDao updateDao;
    @Override
    public List<Song> UpdateSong() {
        return updateDao.UpdateSong();
    }
    @Override
    public int InsertSong(int sid, String song_url) {
        return updateDao.InsertSong(sid,song_url);
    }

    @Override
    public List<Song> SelectMv() {
        return updateDao.SelectMv();
    }

    @Override
    public int InsertMv(int sid, String mv_url) {
        return updateDao.InsertMv(sid,mv_url);
    }


}
