package com.example.demo.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class UserResponseDTO {
    private int ID;
    private String name;
    private String gender;
    private String phone;
    private long age;
    private List<UserCarsResponseDTO> cars;
    private LocalDate birthDate;

    public UserResponseDTO(int ID, String name, long age, LocalDate birthDate, String gender, String phone, List<UserCarsResponseDTO> cars) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.cars = cars;
        this.age = age;
        this.birthDate = birthDate;
    }
}
