package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private long age;
    private String gender;
    private String birthDate;
    private String phone;
    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<Car> cars;

    public User(String name, String gender, String birthDate, String phone) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phone = phone;
        this.age = calcAge(birthDate);
    }

    public User() {
    }

    public long calcAge(String birthDate) {
        String[] stringDate = birthDate.split("-");
        int year = Integer.parseInt(stringDate[0]);
        int month = Integer.parseInt(stringDate[1]);
        int day = Integer.parseInt(stringDate[2]);
        LocalDate formattedBirthDate = LocalDate.of(year, month, day);
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime formattedBirthDateTime = LocalDateTime.of(formattedBirthDate, LocalTime.now());
        long daysDiff = Duration.between(formattedBirthDateTime, today).toDays();
        return daysDiff / 365;
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    private void calcAgeAfterLoad() {
        this.age = calcAge(this.birthDate);
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
