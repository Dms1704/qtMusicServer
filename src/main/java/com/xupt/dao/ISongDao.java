package com.xupt.dao;

import com.xupt.domain.Song;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongDao {

    @Select("select *from song")
    public List<Song> SelectAll();

    @Delete("DELETE FROM song WHERE sid=#{sid}")
    public int DeleteSong(int sid);
}
