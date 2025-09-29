package com.taki.gymgeniusbackend.repository;

import com.taki.gymgeniusbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
