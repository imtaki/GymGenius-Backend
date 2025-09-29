package com.taki.gymgeniusbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "workout_exercises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "plan_id")
    private WorkoutPlan plan;

    @ManyToOne @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private Integer sets;
    private Integer reps;
    private BigDecimal weight;
}
