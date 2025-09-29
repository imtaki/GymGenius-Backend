package com.taki.gymgeniusbackend.controller;

import com.taki.gymgeniusbackend.dto.workoutexercise.WorkoutExerciseDTO;
import com.taki.gymgeniusbackend.dto.workoutplan.WorkoutPlanDTO;
import com.taki.gymgeniusbackend.entity.WorkoutPlan;
import com.taki.gymgeniusbackend.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/plans")
@RequiredArgsConstructor
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<WorkoutPlanDTO>> getPlans(@PathVariable Long userId) {
        List<WorkoutPlanDTO> dtoList = workoutPlanService.getPlansByUser(userId).stream()
                .map(plan -> {
                    WorkoutPlanDTO dto = mapper.map(plan, WorkoutPlanDTO.class);
                    dto.setExercises(plan.getExercises().stream()
                            .map(we -> mapper.map(we, WorkoutExerciseDTO.class))
                            .toList());
                    return dto;
                }).toList();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<WorkoutPlan> createPlan(@PathVariable Long userId, @RequestBody WorkoutPlan plan) {
        return ResponseEntity.ok(workoutPlanService.createPlan(userId, plan));
    }
}
