package com.xupt.domain;

import java.io.Serializable;
import java.util.Date;

public class Discuss implements Serializable {

    private Integer did;
    private Integer uid;
    private Date dtime;
    private String describe;
    private Integer sid;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "did=" + did +
                ", uid=" + uid +
                ", dtime=" + dtime +
                ", describe='" + describe + '\'' +
                ", sid=" + sid +
                '}';
    }
}
