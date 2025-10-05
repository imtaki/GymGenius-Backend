package com.taki.gymgeniusbackend.service;

import com.taki.gymgeniusbackend.dto.workoutexercise.WorkoutExerciseDTO;
import com.taki.gymgeniusbackend.entity.Exercise;
import com.taki.gymgeniusbackend.entity.WorkoutExercise;
import com.taki.gymgeniusbackend.entity.WorkoutPlan;
import com.taki.gymgeniusbackend.repository.ExerciseRepository;
import com.taki.gymgeniusbackend.repository.WorkoutExerciseRepository;
import com.taki.gymgeniusbackend.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutExerciseService {
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public List<WorkoutExerciseDTO> getExercisesByPlan(Long planId) {
        return workoutExerciseRepository.findByPlanId(planId)
                .stream()
                .map(we -> {
                    WorkoutExerciseDTO dto = new WorkoutExerciseDTO();
                    dto.setId(we.getId());
                    dto.setExerciseId(we.getExercise().getId());
                    dto.setSets(we.getSets());
                    dto.setReps(we.getReps());
                    dto.setWeight(we.getWeight());
                    return dto;
                })
                .toList();
    }

    public WorkoutExerciseDTO addExerciseToPlan(Long planId, WorkoutExerciseDTO dto) {
        WorkoutPlan plan = workoutPlanRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
        Exercise exercise = exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        WorkoutExercise we = new WorkoutExercise();
        we.setPlan(plan);
        we.setExercise(exercise);
        we.setSets(dto.getSets());
        we.setReps(dto.getReps());
        we.setWeight(dto.getWeight());

        WorkoutExercise saved = workoutExerciseRepository.save(we);

        WorkoutExerciseDTO savedDto = new WorkoutExerciseDTO();
        savedDto.setId(saved.getId());
        savedDto.setExerciseId(exercise.getId());
        savedDto.setSets(saved.getSets());
        savedDto.setReps(saved.getReps());
        savedDto.setWeight(saved.getWeight());

        return savedDto;
    }
}

