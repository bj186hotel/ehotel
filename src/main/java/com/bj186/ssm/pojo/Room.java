package com.bj186.ssm.pojo;

import java.util.List;

public class Room {
    private Integer roomid;

    private String roomnum;

    private Double newprice;

    private Integer promotion;

    private String defimg;

    private Integer state;

    private String remark;

    private List<RoomImg> roomImgs;

    private List<Order> orders;

    private List<Comment> comments;

    private RoomType roomType;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum == null ? null : roomnum.trim();
    }

    public Double getNewprice() {
        return newprice;
    }

    public void setNewprice(Double newprice) {
        this.newprice = newprice;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public String getDefimg() {
        return defimg;
    }

    public void setDefimg(String defimg) {
        this.defimg = defimg == null ? null : defimg.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<RoomImg> getRoomImgs() {
        return roomImgs;
    }

    public void setRoomImgs(List<RoomImg> roomImgs) {
        this.roomImgs=roomImgs;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders=orders;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments=comments;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType=roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomid=" + roomid +
                ", roomnum='" + roomnum + '\'' +
                ", newprice=" + newprice +
                ", promotion=" + promotion +
                ", defimg='" + defimg + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", roomImgs=" + roomImgs +
                ", orders=" + orders +
                ", comments=" + comments +
                ", roomType=" + roomType +
                '}';
    }
}