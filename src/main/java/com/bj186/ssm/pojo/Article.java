package com.bj186.ssm.pojo;

import java.util.Date;

public class Article {
    private Integer artid;

    private String artname;

    private String arttype;

    private String arttext;

    private String artgurl;

    private String author;

    private Date pubtime;

    private String remark;

    public Integer getArtid() {
        return artid;
    }

    public void setArtid(Integer artid) {
        this.artid = artid;
    }

    public String getArtname() {
        return artname;
    }

    public void setArtname(String artname) {
        this.artname = artname == null ? null : artname.trim();
    }

    public String getArttype() {
        return arttype;
    }

    public void setArttype(String arttype) {
        this.arttype = arttype == null ? null : arttype.trim();
    }

    public String getArttext() {
        return arttext;
    }

    public void setArttext(String arttext) {
        this.arttext = arttext == null ? null : arttext.trim();
    }

    public String getArtgurl() {
        return artgurl;
    }

    public void setArtgurl(String artgurl) {
        this.artgurl = artgurl == null ? null : artgurl.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}