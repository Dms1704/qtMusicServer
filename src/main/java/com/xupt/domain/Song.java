package com.xupt.domain;

public class Song {
    private Integer sid;
    private String songname;
    private String author;
    private String url;
    private String img;
    private Integer mv_status;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getMv_status() {
        return mv_status;
    }

    public void setMv_status(Integer mv_status) {
        this.mv_status = mv_status;
    }

    @Override
    public String toString() {
        return "Song{" +
                "sid=" + sid +
                ", songname='" + songname + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", mv_status=" + mv_status +
                '}';
    }
}
