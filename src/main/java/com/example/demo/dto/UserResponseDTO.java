package com.example.demo.dto;

import com.example.demo.model.Car;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {
    private int ID;
    private String name;
    private List<UserCarsDTO> cars;

    public UserResponseDTO(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.cars = new ArrayList<UserCarsDTO>();
    }

    public void setCars(List<UserCarsDTO> cars) {
        this.cars = cars;
    }

    public void addCar(UserCarsDTO car) {
        this.cars.add(car);
    }

    //TODO: Remove car method
}
