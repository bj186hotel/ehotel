package com.bj186.ssm.pojo;

import java.util.Date;

public class EnterOrderList {
    private Integer enterListId;

    private Integer pronNumber1;

    private Integer pronNumber2;

    private Date modifiedTime;

    private String remark;

    private EnterOrder enterOrder;

    private Item item;

    public Integer getEnterListId() {
        return enterListId;
    }

    public void setEnterListId(Integer enterListId) {
        this.enterListId = enterListId;
    }

    public Integer getPronNumber1() {
        return pronNumber1;
    }

    public void setPronNumber1(Integer pronNumber1) {
        this.pronNumber1 = pronNumber1;
    }

    public Integer getPronNumber2() {
        return pronNumber2;
    }

    public void setPronNumber2(Integer pronNumber2) {
        this.pronNumber2 = pronNumber2;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public EnterOrder getEnterOrder() {
        return enterOrder;
    }

    public void setEnterOrder(EnterOrder enterOrder) {
        this.enterOrder=enterOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item=item;
    }
}