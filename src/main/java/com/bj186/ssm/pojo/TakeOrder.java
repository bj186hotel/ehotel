package com.bj186.ssm.pojo;

public class TakeOrder {
    private String takeoutOrderId;

    private String takeoutId;

    private String takeoutNumber;

    private TakeOrder takeOrder;

    private Item item;

    public String getTakeoutOrderId() {
        return takeoutOrderId;
    }

    public void setTakeoutOrderId(String takeoutOrderId) {
        this.takeoutOrderId = takeoutOrderId == null ? null : takeoutOrderId.trim();
    }

    public String getTakeoutId() {
        return takeoutId;
    }

    public void setTakeoutId(String takeoutId) {
        this.takeoutId = takeoutId == null ? null : takeoutId.trim();
    }

    public String getTakeoutNumber() {
        return takeoutNumber;
    }

    public void setTakeoutNumber(String takeoutNumber) {
        this.takeoutNumber = takeoutNumber == null ? null : takeoutNumber.trim();
    }

    public TakeOrder getTakeOrder() {
        return takeOrder;
    }

    public void setTakeOrder(TakeOrder takeOrder) {
        this.takeOrder=takeOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item=item;
    }
}