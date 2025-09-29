package com.taki.gymgeniusbackend.service;

import com.taki.gymgeniusbackend.entity.User;
import com.taki.gymgeniusbackend.entity.WorkoutPlan;
import com.taki.gymgeniusbackend.repository.UserRepository;
import com.taki.gymgeniusbackend.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkoutPlanService {
    private final WorkoutPlanRepository workoutPlanRepository;
    private final UserRepository userRepository;


    public List<WorkoutPlan> getPlansByUser(Long userId) {
        return workoutPlanRepository.findAll()
                .stream()
                .filter(p -> p.getUser().getId().equals(userId))
                .toList();
    }

    public WorkoutPlan createPlan(Long userId, WorkoutPlan plan) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        plan.setUser(user);
        return workoutPlanRepository.save(plan);
    }
}
