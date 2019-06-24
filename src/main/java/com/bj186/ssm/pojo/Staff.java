package com.bj186.ssm.pojo;

import java.util.Date;

public class Staff {
    private Integer empid;

    private String empname;

    private String empsex;

    private Integer empage;

    private String empphone;

    private Integer empwage;

    private String empemail;

    private String emppay;

    private Date emplasttime;

    private String remark;

    private Department department;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getEmpsex() {
        return empsex;
    }

    public void setEmpsex(String empsex) {
        this.empsex = empsex == null ? null : empsex.trim();
    }

    public Integer getEmpage() {
        return empage;
    }

    public void setEmpage(Integer empage) {
        this.empage = empage;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone == null ? null : empphone.trim();
    }

    public Integer getEmpwage() {
        return empwage;
    }

    public void setEmpwage(Integer empwage) {
        this.empwage = empwage;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail == null ? null : empemail.trim();
    }

    public String getEmppay() {
        return emppay;
    }

    public void setEmppay(String emppay) {
        this.emppay = emppay == null ? null : emppay.trim();
    }

    public Date getEmplasttime() {
        return emplasttime;
    }

    public void setEmplasttime(Date emplasttime) {
        this.emplasttime = emplasttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department=department;
    }
}