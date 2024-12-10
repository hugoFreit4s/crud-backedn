package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {
    private int ID;
    private String name;
    private String gender;
    private String phone;
    private int age;
    private List<UserCarsResponseDTO> cars;

    public UserResponseDTO(int ID, String name, String gender, String phone, int age, List<UserCarsResponseDTO> cars) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.age = age;
        this.cars = cars;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
