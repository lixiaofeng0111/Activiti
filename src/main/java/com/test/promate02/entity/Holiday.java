package com.test.promate02.entity;

import java.util.Date;

/**
 * Title: Holiday.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月11日
 */
public class Holiday {
/**
 * Class description:POJO类（请假申请单类）
 * @Author: lxf
 */
    private String id; //请假单id
    private String Name; //请假人员名称
    private Date startTime; //请假开始时间
    private Date endTime; //请假结束时间
    private Float num; //请假天数
    private String reason; //请假事由
    private String type;//请假类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
