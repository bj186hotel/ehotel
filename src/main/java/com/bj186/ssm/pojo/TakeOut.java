package com.bj186.ssm.pojo;

import java.util.Date;
import java.util.List;

public class TakeOut {
    private String takeoutId;

    private Date takeoutTime;

    private Integer auditState;

    private String remark;

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

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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