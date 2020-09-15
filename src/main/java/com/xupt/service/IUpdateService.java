package com.xupt.service;

import com.xupt.domain.Song;

import java.util.List;

public interface IUpdateService {
    public List<Song> UpdateSong();
    public int InsertSong(int sid, String song_url);
    public List<Song> SelectMv();
    public int InsertMv(int sid, String mv_url);
}
