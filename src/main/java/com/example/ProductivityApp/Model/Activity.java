package com.example.ProductivityApp.Model;

import com.example.ProductivityApp.Enum.ActivityPointsEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;
@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long activityId;
    @Column(name="activity_name")
    private String activityName;
    @Column(name="hours_spent")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime activityTimeSpent; //time spent on certain activity
    @Column(name="activity_start")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date activityStartDate;
    @Column(name="activity_points")
    private ActivityPointsEnum activityPointsEnum;

    public Activity(String activityName, LocalTime activityTimeSpent, Date activityStartDate,
                    Long activityId, ActivityPointsEnum activityPointsEnum) {
        this.activityName = activityName;
        this.activityTimeSpent = activityTimeSpent;
        this.activityStartDate = activityStartDate;
        this.activityId = activityId;
        this.activityPointsEnum=activityPointsEnum;
    }

    public Activity() {}

    public ActivityPointsEnum getActivityPointsEnum() {
        return activityPointsEnum;
    }

    public void setActivityPointsEnum(ActivityPointsEnum activityPointsEnum) {
        this.activityPointsEnum = activityPointsEnum;
    }

    public Long getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public LocalTime getActivityTimeSpent() {
        return activityTimeSpent;
    }

    public void setActivityTimeSpent(LocalTime activityTimeSpent) {
        this.activityTimeSpent = activityTimeSpent;
    }

    public Date getActivityStartDate() {
        return activityStartDate;
    }

    public void setActivityStartDate(Date activityStartDate) {
        this.activityStartDate = activityStartDate;
    }

}
