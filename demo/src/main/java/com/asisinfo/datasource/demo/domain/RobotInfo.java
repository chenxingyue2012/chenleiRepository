package com.asisinfo.datasource.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class RobotInfo implements Serializable {
    private String robotCode;
    private String robotName;
    private int robotAge;
    private Date createDate;
    private String status;
    private String remark;

    public  RobotInfo() {
    }

    public  RobotInfo(String robotCode, String robotName, int robotAge, Date createDate, String status, String remark) {
        this.robotCode = robotCode;
        this.robotName = robotName;
        this.robotAge = robotAge;
        this.createDate = createDate;
        this.status = status;
        this.remark = remark;
    }

    public String getRobotCode() {
        return robotCode;
    }

    public void setRobotCode(String robotCode) {
        this.robotCode = robotCode;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public int getRobotAge() {
        return robotAge;
    }

    public void setRobotAge(int robotAge) {
        this.robotAge = robotAge;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "RobotInfo{" +
                "robotCode='" + robotCode + '\'' +
                ", robotName='" + robotName + '\'' +
                ", robotAge=" + robotAge +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
