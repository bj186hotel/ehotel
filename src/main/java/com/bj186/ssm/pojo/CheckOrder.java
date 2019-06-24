package com.bj186.ssm.pojo;

public class CheckOrder {
    private String checkOrderId;

    private String remark;

    private Check check;

    private EnterOrder enterOrder;

    public String getCheckOrderId() {
        return checkOrderId;
    }

    public void setCheckOrderId(String checkOrderId) {
        this.checkOrderId = checkOrderId == null ? null : checkOrderId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check=check;
    }

    public EnterOrder getEnterOrder() {
        return enterOrder;
    }

    public void setEnterOrder(EnterOrder enterOrder) {
        this.enterOrder=enterOrder;
    }
}