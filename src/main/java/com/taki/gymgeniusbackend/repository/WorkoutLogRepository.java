package com.taki.gymgeniusbackend.repository;

import com.taki.gymgeniusbackend.entity.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {
}
