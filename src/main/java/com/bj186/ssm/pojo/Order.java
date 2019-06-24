package com.bj186.ssm.pojo;

import java.util.Date;

public class Order {
    private Integer orderid;

    private String orderstate;

    private Integer oldprice;

    private Integer newprice;

    private Integer otherprice;

    private Date ordertime;

    private Integer personnum;

    private Date intime;

    private Date outtime;

    private String remark;

    private Room room;

    private Member member;

    private User user;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate == null ? null : orderstate.trim();
    }

    public Integer getOldprice() {
        return oldprice;
    }

    public void setOldprice(Integer oldprice) {
        this.oldprice = oldprice;
    }

    public Integer getNewprice() {
        return newprice;
    }

    public void setNewprice(Integer newprice) {
        this.newprice = newprice;
    }

    public Integer getOtherprice() {
        return otherprice;
    }

    public void setOtherprice(Integer otherprice) {
        this.otherprice = otherprice;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getPersonnum() {
        return personnum;
    }

    public void setPersonnum(Integer personnum) {
        this.personnum = personnum;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }
}