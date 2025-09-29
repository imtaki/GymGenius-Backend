package com.taki.gymgeniusbackend.repository;

import com.taki.gymgeniusbackend.entity.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
}
