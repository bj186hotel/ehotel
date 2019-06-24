package com.bj186.ssm.pojo;

public class TakeOrder {
    private Integer takeoutOrderId;

    private Integer takeoutNumber;

    private TakeOut takeOut;

    private Item item;

    public Integer getTakeoutOrderId() {
        return takeoutOrderId;
    }

    public void setTakeoutOrderId(Integer takeoutOrderId) {
        this.takeoutOrderId = takeoutOrderId;
    }

    public Integer getTakeoutNumber() {
        return takeoutNumber;
    }

    public void setTakeoutNumber(Integer takeoutNumber) {
        this.takeoutNumber = takeoutNumber;
    }

    public TakeOut getTakeOut() {
        return takeOut;
    }

    public void setTakeOut(TakeOut takeOut) {
        this.takeOut=takeOut;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item=item;
    }
}