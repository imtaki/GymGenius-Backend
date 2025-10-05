package com.taki.gymgeniusbackend.service;

import com.taki.gymgeniusbackend.dto.workoutplan.WorkoutPlanDTO;
import com.taki.gymgeniusbackend.entity.User;
import com.taki.gymgeniusbackend.entity.WorkoutPlan;
import com.taki.gymgeniusbackend.repository.UserRepository;
import com.taki.gymgeniusbackend.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkoutPlanService {
    private final WorkoutPlanRepository workoutPlanRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public List<WorkoutPlan> getPlansByUser(Long userId) {
        return workoutPlanRepository.findAll()
                .stream()
                .filter(p -> p.getUser().getId().equals(userId))
                .toList();
    }

    public WorkoutPlanDTO createWorkoutPlan(Long userId, WorkoutPlanDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        WorkoutPlan plan = new WorkoutPlan();
        plan.setName(dto.getName());
        plan.setUser(user);

        WorkoutPlan saved = workoutPlanRepository.save(plan);

        return modelMapper.map(saved, WorkoutPlanDTO.class);
    }
}
