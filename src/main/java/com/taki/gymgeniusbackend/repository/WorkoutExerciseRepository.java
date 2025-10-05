package com.taki.gymgeniusbackend.repository;

import com.taki.gymgeniusbackend.entity.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {
    List<WorkoutExercise> findByPlanId(Long planId);
}
