package com.bj186.ssm.pojo;

import java.util.Date;

public class Order {
    private Integer orderid;

    private String orderstate;

    private Double oldprice;

    private Double newprice;

    private Double otherprice;

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

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    public Double getNewprice() {
        return newprice;
    }

    public void setNewprice(Double newprice) {
        this.newprice = newprice;
    }

    public Double getOtherprice() {
        return otherprice;
    }

    public void setOtherprice(Double otherprice) {
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

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", orderstate='" + orderstate + '\'' +
                ", oldprice=" + oldprice +
                ", newprice=" + newprice +
                ", otherprice=" + otherprice +
                ", ordertime=" + ordertime +
                ", personnum=" + personnum +
                ", intime=" + intime +
                ", outtime=" + outtime +
                ", remark='" + remark + '\'' +
                ", room=" + room +
                ", member=" + member +
                ", user=" + user +
                '}';
    }
}