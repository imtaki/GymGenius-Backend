package com.taki.gymgeniusbackend.repository;

import com.taki.gymgeniusbackend.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
