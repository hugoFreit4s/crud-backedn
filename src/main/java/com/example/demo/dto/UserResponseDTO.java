package com.example.demo.dto;

import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class UserResponseDTO {
    private int ID;
    private String name;
    private String gender;
    private String phone;
    private long age;
    private List<UserCarsResponseDTO> cars;

    public UserResponseDTO(int ID, String name, String birthDate, String gender, String phone, List<UserCarsResponseDTO> cars) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.cars = cars;
        this.age = calcAge(birthDate);
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

    public void setCars(List<UserCarsResponseDTO> cars) {
        this.cars = cars;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public List<UserCarsResponseDTO> getCars() {
        return cars;
    }

    public void addCar(UserCarsResponseDTO car) {
        this.cars.add(car);
    }

    //TODO: Remove car method
}
