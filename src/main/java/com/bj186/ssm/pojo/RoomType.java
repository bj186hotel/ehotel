package com.bj186.ssm.pojo;

import java.util.List;

public class RoomType {
    private Integer rtypeid;

    private String rtypename;

    private Integer resmon;

    private Integer livenum;

    private String depmoney;

    private String facility;

    private Integer isfood;

    private String remark;

    private List<Room> rooms;

    public Integer getRtypeid() {
        return rtypeid;
    }

    public void setRtypeid(Integer rtypeid) {
        this.rtypeid = rtypeid;
    }

    public String getRtypename() {
        return rtypename;
    }

    public void setRtypename(String rtypename) {
        this.rtypename = rtypename == null ? null : rtypename.trim();
    }

    public Integer getResmon() {
        return resmon;
    }

    public void setResmon(Integer resmon) {
        this.resmon = resmon;
    }

    public Integer getLivenum() {
        return livenum;
    }

    public void setLivenum(Integer livenum) {
        this.livenum = livenum;
    }

    public String getDepmoney() {
        return depmoney;
    }

    public void setDepmoney(String depmoney) {
        this.depmoney = depmoney == null ? null : depmoney.trim();
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility == null ? null : facility.trim();
    }

    public Integer getIsfood() {
        return isfood;
    }

    public void setIsfood(Integer isfood) {
        this.isfood = isfood;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms=rooms;
    }
}