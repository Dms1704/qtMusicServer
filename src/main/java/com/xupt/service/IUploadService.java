package com.xupt.service;

import com.xupt.domain.Song;

import java.util.List;

public interface IUploadService {
    public int SongUpload(Song song);
    public int SongPlayNum(int sid);
    public int MvUpload(int sid, String mv_url);
    public List<Song> MvSelect();
    public List<Integer> SelectMid(int sid);
    public int MvPlayNum(int mid);
}
