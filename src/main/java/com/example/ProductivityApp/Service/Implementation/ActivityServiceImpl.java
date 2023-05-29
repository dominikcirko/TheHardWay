package com.example.ProductivityApp.Service.Implementation;

import com.example.ProductivityApp.Model.Activity;
import com.example.ProductivityApp.Repository.ActivityRepository;
import com.example.ProductivityApp.Service.Interface.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(Optional<Long> id) {
        activityRepository.deleteById(id.get());
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
}
