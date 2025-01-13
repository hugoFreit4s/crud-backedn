package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private long age;
    private String gender;
    private LocalDate birthDate;
    private String phone;
    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<Car> cars;

    public User(String name, String gender, LocalDate birthDate, String phone) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phone = phone;
        this.age = 0; //TODO: age calc
    }

    public User() {
    }
}
