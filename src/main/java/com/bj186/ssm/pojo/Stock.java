package com.bj186.ssm.pojo;

public class Stock {
    private Integer stockId;

    private Integer count;

    private String remark;

    private Item item;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item=item;
    }
}