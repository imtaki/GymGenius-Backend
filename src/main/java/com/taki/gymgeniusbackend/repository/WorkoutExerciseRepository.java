package com.taki.gymgeniusbackend.repository;

import com.taki.gymgeniusbackend.entity.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {
}
