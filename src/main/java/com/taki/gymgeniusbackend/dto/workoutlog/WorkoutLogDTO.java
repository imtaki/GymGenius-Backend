package com.taki.gymgeniusbackend.dto.workoutlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutLogDTO {
    private Long id;
    private LocalDate date;
    private Long exerciseId;
    private String exerciseName;
    private Integer sets;
    private Integer reps;
    private BigDecimal weight;
}
