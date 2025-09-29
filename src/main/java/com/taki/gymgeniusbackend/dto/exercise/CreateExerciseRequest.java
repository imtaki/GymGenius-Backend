package com.taki.gymgeniusbackend.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateExerciseRequest {
    private String name;
    private String muscleGroup;
    private String description;
}
