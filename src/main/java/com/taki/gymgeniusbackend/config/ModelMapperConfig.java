package com.taki.gymgeniusbackend.config;

import com.taki.gymgeniusbackend.dto.workoutexercise.WorkoutExerciseDTO;
import com.taki.gymgeniusbackend.dto.workoutlog.WorkoutLogDTO;
import com.taki.gymgeniusbackend.entity.WorkoutExercise;
import com.taki.gymgeniusbackend.entity.WorkoutLog;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // Custom mapping for nested exercise name
        mapper.typeMap(WorkoutExercise.class, WorkoutExerciseDTO.class)
                .addMappings(m -> {
                    m.map(src -> src.getExercise().getId(), WorkoutExerciseDTO::setExerciseId);
                    m.map(src -> src.getExercise().getName(), WorkoutExerciseDTO::setExerciseName);
                });

        mapper.typeMap(WorkoutLog.class, WorkoutLogDTO.class)
                .addMappings(m -> {
                    m.map(src -> src.getExercise().getId(), WorkoutLogDTO::setExerciseId);
                    m.map(src -> src.getExercise().getName(), WorkoutLogDTO::setExerciseName);
                });

        return mapper;
    }
}



