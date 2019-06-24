package com.bj186.ssm.pojo;

import java.util.Date;
import java.util.List;

public class Takeout {
    private String takeoutId;

    private Date takeoutTime;

    private String userid;

    private Integer auditState;

    private byte[] remark;

    private List<TakeOrder> takeOrders;

    private User user;

    public String getTakeoutId() {
        return takeoutId;
    }

    public void setTakeoutId(String takeoutId) {
        this.takeoutId = takeoutId == null ? null : takeoutId.trim();
    }

    public Date getTakeoutTime() {
        return takeoutTime;
    }

    public void setTakeoutTime(Date takeoutTime) {
        this.takeoutTime = takeoutTime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public byte[] getRemark() {
        return remark;
    }

    public void setRemark(byte[] remark) {
        this.remark = remark;
    }

    public List<TakeOrder> getTakeOrders() {
        return takeOrders;
    }

    public void setTakeOrders(List<TakeOrder> takeOrders) {
        this.takeOrders=takeOrders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }
}