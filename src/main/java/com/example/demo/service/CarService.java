package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> listAllCars() {
        return carRepository.findAll();
    }

    public String insertCar(Car car) {
        carRepository.save(car);
        return car.getName() + " " + car.getOwner();
    }
}
