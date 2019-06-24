package com.bj186.ssm.pojo;

public class Comment {
    private Integer commid;

    private String commtext;

    private String remark;

    private Room room;

    private Member member;

    public Integer getCommid() {
        return commid;
    }

    public void setCommid(Integer commid) {
        this.commid = commid;
    }

    public String getCommtext() {
        return commtext;
    }

    public void setCommtext(String commtext) {
        this.commtext = commtext == null ? null : commtext.trim();
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member=member;
    }
}