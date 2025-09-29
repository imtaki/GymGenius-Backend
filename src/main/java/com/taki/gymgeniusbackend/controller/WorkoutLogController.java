package com.taki.gymgeniusbackend.controller;

import com.taki.gymgeniusbackend.dto.workoutlog.CreateWorkoutLogRequest;
import com.taki.gymgeniusbackend.dto.workoutlog.WorkoutLogDTO;
import com.taki.gymgeniusbackend.entity.WorkoutLog;
import com.taki.gymgeniusbackend.service.WorkoutLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/logs")
@RequiredArgsConstructor
public class WorkoutLogController {
    private final WorkoutLogService workoutLogService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<WorkoutLogDTO>> getWorkoutLogs(@PathVariable Long userId) {
        List<WorkoutLogDTO> dtoList = workoutLogService.getLogsByUser(userId).stream()
                .map(l -> mapper.map(l, WorkoutLogDTO.class))
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping()
    public ResponseEntity<WorkoutLogDTO> addLog(@PathVariable Long userId,
                                                @RequestBody CreateWorkoutLogRequest req) {
        WorkoutLog log = new WorkoutLog();
        log.setDate(req.getDate());
        log.setSets(req.getSets());
        log.setReps(req.getReps());
        log.setWeight(req.getWeight());
        WorkoutLog saved = workoutLogService.addLog(userId, req.getExerciseId(), log);
        return ResponseEntity.ok(mapper.map(saved, WorkoutLogDTO.class));
    }
}
