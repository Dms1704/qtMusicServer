package com.xupt.dao;

import com.xupt.domain.Song;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUpdateDao {
    @Select("select sid,url from song")
    public List<Song> UpdateSong();
    @Update("UPDATE song SET url=#{song_url} WHERE sid =#{sid}")
    public int InsertSong(@Param("sid") int sid, @Param("song_url") String song_url);
    @Select("SELECT sid,mv_status FROM song WHERE mv_status!=0")
    public List<Song> SelectMv();
    @Update("update mv set mv_url=#{mv_url} where sid=#{sid}")
    public int InsertMv(@Param("sid") int sid, @Param("mv_url") String mv_url);
}
