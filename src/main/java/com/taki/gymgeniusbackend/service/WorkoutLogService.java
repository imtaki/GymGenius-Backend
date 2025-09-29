package com.taki.gymgeniusbackend.service;

import com.taki.gymgeniusbackend.entity.WorkoutLog;
import com.taki.gymgeniusbackend.repository.ExerciseRepository;
import com.taki.gymgeniusbackend.repository.UserRepository;
import com.taki.gymgeniusbackend.repository.WorkoutLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkoutLogService {
    private final WorkoutLogRepository logRepository;
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;

    public List<WorkoutLog> getLogsByUser(Long userId) {
        return logRepository.findAll().stream()
                .filter(l -> l.getUser().getId().equals(userId))
                .toList();
    }

    public WorkoutLog addLog(Long userId, Long exerciseId, WorkoutLog log) {
        log.setUser(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        log.setExercise(exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise not found")));
        return logRepository.save(log);
    }
}
