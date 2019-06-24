package com.bj186.ssm.pojo;

import java.util.Date;
import java.util.List;

public class Member {
    private Integer memid;

    private String mennum;

    private String memname;

    private String phone;

    private String mempaw;

    private String memsex;

    private String idcard;

    private String email;

    private Integer memint;

    private Double discount;

    private Date regisdate;

    private String userstate;

    private String remark;

    private List<Order> orders;

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public String getMennum() {
        return mennum;
    }

    public void setMennum(String mennum) {
        this.mennum = mennum == null ? null : mennum.trim();
    }

    public String getMemname() {
        return memname;
    }

    public void setMemname(String memname) {
        this.memname = memname == null ? null : memname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMempaw() {
        return mempaw;
    }

    public void setMempaw(String mempaw) {
        this.mempaw = mempaw == null ? null : mempaw.trim();
    }

    public String getMemsex() {
        return memsex;
    }

    public void setMemsex(String memsex) {
        this.memsex = memsex == null ? null : memsex.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getMemint() {
        return memint;
    }

    public void setMemint(Integer memint) {
        this.memint = memint;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getRegisdate() {
        return regisdate;
    }

    public void setRegisdate(Date regisdate) {
        this.regisdate = regisdate;
    }

    public String getUserstate() {
        return userstate;
    }

    public void setUserstate(String userstate) {
        this.userstate = userstate == null ? null : userstate.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders=orders;
    }
}