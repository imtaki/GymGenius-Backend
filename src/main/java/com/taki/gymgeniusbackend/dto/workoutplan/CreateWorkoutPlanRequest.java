package com.taki.gymgeniusbackend.dto.workoutplan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkoutPlanRequest {
    private String name;
    private List<Long> exerciseIds;
}
