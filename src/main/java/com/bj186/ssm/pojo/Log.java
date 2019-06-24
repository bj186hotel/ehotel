package com.bj186.ssm.pojo;

import java.util.Date;

public class Log {
    private Integer logsid;

    private String logstype;

    private String logstext;

    private Date commpp;

    private String remark;

    private Staff staff;

    public Integer getLogsid() {
        return logsid;
    }

    public void setLogsid(Integer logsid) {
        this.logsid = logsid;
    }

    public String getLogstype() {
        return logstype;
    }

    public void setLogstype(String logstype) {
        this.logstype = logstype == null ? null : logstype.trim();
    }

    public String getLogstext() {
        return logstext;
    }

    public void setLogstext(String logstext) {
        this.logstext = logstext == null ? null : logstext.trim();
    }

    public Date getCommpp() {
        return commpp;
    }

    public void setCommpp(Date commpp) {
        this.commpp = commpp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff=staff;
    }
}