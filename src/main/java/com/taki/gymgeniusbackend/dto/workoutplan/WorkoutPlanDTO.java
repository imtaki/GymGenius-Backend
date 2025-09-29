package com.taki.gymgeniusbackend.dto.workoutplan;

import com.taki.gymgeniusbackend.dto.workoutexercise.WorkoutExerciseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutPlanDTO {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private List<WorkoutExerciseDTO> exercises;
}

