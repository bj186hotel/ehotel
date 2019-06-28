package com.bj186.ssm.pojo;

import java.util.Date;
import java.util.List;

public class EnterOrder {
    private Integer enterOrderId;

    private Double costMoney;

    private Double costMoney2;

    private Integer status;

    private Date modifiedTime2;

    private Date modifiedTime;

    private List<EnterOrderList> enterOrderLists;

    private User user;

    public Integer getEnterOrderId() {
        return enterOrderId;
    }

    public void setEnterOrderId(Integer enterOrderId) {
        this.enterOrderId = enterOrderId;
    }

    public Double getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Double costMoney) {
        this.costMoney = costMoney;
    }

    public Double getCostMoney2() {
        return costMoney2;
    }

    public void setCostMoney2(Double costMoney2) {
        this.costMoney2 = costMoney2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getModifiedTime2() {
        return modifiedTime2;
    }

    public void setModifiedTime2(Date modifiedTime2) {
        this.modifiedTime2 = modifiedTime2;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<EnterOrderList> getEnterOrderLists() {
        return enterOrderLists;
    }

    public void setEnterOrderLists(List<EnterOrderList> enterOrderLists) {
        this.enterOrderLists=enterOrderLists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    @Override
    public String toString() {
        return "EnterOrder{" +
                "enterOrderId=" + enterOrderId +
                ", costMoney=" + costMoney +
                ", costMoney2=" + costMoney2 +
                ", status=" + status +
                ", modifiedTime2=" + modifiedTime2 +
                ", modifiedTime=" + modifiedTime +
                ", enterOrderLists=" + enterOrderLists +
                ", user=" + user +
                '}';
    }
}