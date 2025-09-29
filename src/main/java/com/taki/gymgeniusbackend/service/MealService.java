package com.taki.gymgeniusbackend.service;

import com.taki.gymgeniusbackend.entity.Meal;
import com.taki.gymgeniusbackend.repository.MealRepository;
import com.taki.gymgeniusbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    public List<Meal> getMealsByUser(Long userId) {
        return mealRepository.findAll().stream()
                .filter(m -> m.getUser().getId().equals(userId))
                .toList();
    }

    public Meal addMeal(Long userId, Meal meal) {
        meal.setUser(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        return mealRepository.save(meal);
    }

}
