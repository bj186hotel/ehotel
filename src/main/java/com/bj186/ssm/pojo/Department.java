package com.bj186.ssm.pojo;

import java.util.List;

public class Department {
    private Integer depid;

    private String depname;

    private String depinfor;

    private String remark;

    private List<Staff> staffs;

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname == null ? null : depname.trim();
    }

    public String getDepinfor() {
        return depinfor;
    }

    public void setDepinfor(String depinfor) {
        this.depinfor = depinfor == null ? null : depinfor.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs=staffs;
    }
}