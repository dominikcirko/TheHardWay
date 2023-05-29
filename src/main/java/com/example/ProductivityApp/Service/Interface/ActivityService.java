package com.example.ProductivityApp.Service.Interface;

import com.example.ProductivityApp.Model.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    Activity createActivity (Activity activity);
    void deleteActivity(Optional<Long> id);
    List<Activity> getAllActivities();

}
