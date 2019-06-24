package com.bj186.ssm.pojo;

public class RoomImg {
    private Integer rimgid;

    private Integer status;

    private String imgurl;

    private String remark;

    private Room room;

    public Integer getRimgid() {
        return rimgid;
    }

    public void setRimgid(Integer rimgid) {
        this.rimgid = rimgid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room=room;
    }
}