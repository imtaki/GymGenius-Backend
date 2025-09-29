package com.taki.gymgeniusbackend.repository;

import com.taki.gymgeniusbackend.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
