package com.bj186.ssm.pojo;

public class CusOrder {
    private Integer cusorderid;

    private Customer customer;

    private Order order;

    public Integer getCusorderid() {
        return cusorderid;
    }

    public void setCusorderid(Integer cusorderid) {
        this.cusorderid = cusorderid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer=customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order=order;
    }
}