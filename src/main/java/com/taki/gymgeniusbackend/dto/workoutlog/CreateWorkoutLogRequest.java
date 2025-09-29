package com.taki.gymgeniusbackend.dto.workoutlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkoutLogRequest {
    private Long exerciseId;
    private LocalDate date;
    private Integer sets;
    private Integer reps;
    private BigDecimal weight;
}
