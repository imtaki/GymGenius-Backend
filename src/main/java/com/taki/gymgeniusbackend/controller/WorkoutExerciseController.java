package com.taki.gymgeniusbackend.controller;

import com.taki.gymgeniusbackend.dto.workoutexercise.WorkoutExerciseDTO;
import com.taki.gymgeniusbackend.service.WorkoutExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plans/{planId}/exercises")
@RequiredArgsConstructor
public class WorkoutExerciseController {
    private final WorkoutExerciseService workoutExerciseService;

    @GetMapping
    public ResponseEntity<List<WorkoutExerciseDTO>> getExercises(@PathVariable Long planId) {
        return ResponseEntity.ok(workoutExerciseService.getExercisesByPlan(planId));
    }

    @PostMapping
    public ResponseEntity<WorkoutExerciseDTO> addExercise(
            @PathVariable Long planId,
            @RequestBody WorkoutExerciseDTO dto) {
        return ResponseEntity.ok(workoutExerciseService.addExerciseToPlan(planId, dto));
    }
}
