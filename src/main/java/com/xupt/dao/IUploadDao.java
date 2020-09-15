package com.xupt.dao;

import com.xupt.domain.Song;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUploadDao {
    @Insert("insert into song(sid,songname,author,url,img,mv_status) values(#{sid},#{songname},#{author},#{url},#{img},#{mv_status})")
    public int SongUpload(Song song);

    @Insert("insert into music_number(play_num,sid) values(0,#{sid})")
    public int SongPlayNum(int sid);

    @Insert("insert into mv(mv_url,sid) values(#{mv_url},#{sid})")
    public int MvUpload(@Param("sid") int sid, @Param("mv_url") String mv_url);

    @Select("select *from song where mv_status!=0")
    public List<Song> MvSelect();

    @Select("SELECT MID FROM mv WHERE sid=#{sid}")
    public List<Integer> SelectMid(int sid);

    @Insert("insert into mv_number(mv_num,mid) values(0,#{mid})")
    public int MvPlayNum(int mid);
}
