package com.taki.gymgeniusbackend.controller;

import com.taki.gymgeniusbackend.dto.user.CreateUserRequest;
import com.taki.gymgeniusbackend.dto.user.UserDTO;
import com.taki.gymgeniusbackend.entity.User;
import com.taki.gymgeniusbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> dtoList = userService.getAllUsers().stream()
                .map(u -> mapper.map(u, UserDTO.class))
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());
        user.setAge(request.getAge());
        user.setHeightInCm(request.getHeightInCm());
        user.setWeightKg(request.getWeightKg());
        user.setFitnessGoal(request.getFitnessGoal());

        User saved = userService.createUser(user);
        return ResponseEntity.ok(mapper.map(saved, UserDTO.class));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
