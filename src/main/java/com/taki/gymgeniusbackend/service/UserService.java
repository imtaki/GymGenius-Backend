package com.taki.gymgeniusbackend.service;

import com.taki.gymgeniusbackend.entity.User;
import com.taki.gymgeniusbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updated) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setUsername(updated.getUsername());
                    u.setAge(updated.getAge());
                    u.setHeightInCm(updated.getHeightInCm());
                    u.setWeightKg(updated.getWeightKg());
                    u.setFitnessGoal(updated.getFitnessGoal());
                    return userRepository.save(u);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }



}
