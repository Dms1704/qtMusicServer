package com.xupt.service;

import com.xupt.domain.Song;

import java.util.List;

public interface ISongService {
    public List<Song> SelectAll();
    public int DeleteSong(int sid);
}
