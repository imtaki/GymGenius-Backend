package com.taki.gymgeniusbackend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private Integer age;
    private Integer heightInCm;
    private BigDecimal weightKg;
    private String fitnessGoal;

}
