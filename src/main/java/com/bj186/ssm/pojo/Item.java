package com.bj186.ssm.pojo;

public class Item {
    private Integer itemid;

    private String itemname;

    private String unit;

    private Integer enterprice;

    private Integer sellprice;

    private ItemType itemType;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getEnterprice() {
        return enterprice;
    }

    public void setEnterprice(Integer enterprice) {
        this.enterprice = enterprice;
    }

    public Integer getSellprice() {
        return sellprice;
    }

    public void setSellprice(Integer sellprice) {
        this.sellprice = sellprice;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType=itemType;
    }
}