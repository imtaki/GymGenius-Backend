package com.taki.gymgeniusbackend.controller;


import com.taki.gymgeniusbackend.dto.meal.CreateMealRequest;
import com.taki.gymgeniusbackend.dto.meal.MealDTO;
import com.taki.gymgeniusbackend.entity.Meal;
import com.taki.gymgeniusbackend.service.MealService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/meals")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MealDTO>> getMeals(@PathVariable Long userId) {
        List<MealDTO> dtoList = mealService.getMealsByUser(userId).stream()
                .map(m -> mapper.map(m, MealDTO.class))
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<MealDTO> addMeal(@PathVariable Long userId,
                                           @RequestBody CreateMealRequest req) {
        Meal meal = mapper.map(req, Meal.class);
        Meal saved = mealService.addMeal(userId, meal);
        return ResponseEntity.ok(mapper.map(saved, MealDTO.class));
    }
}
