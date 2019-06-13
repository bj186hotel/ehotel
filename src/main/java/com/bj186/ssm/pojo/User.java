package com.bj186.ssm.pojo;

public class User {
    private Integer customerId;

    private String customerName;

    private String customerPwd;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPwd() {
        return customerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        this.customerPwd = customerPwd == null ? null : customerPwd.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPwd='" + customerPwd + '\'' +
                '}';
    }
}