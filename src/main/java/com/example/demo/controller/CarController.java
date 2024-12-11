package com.example.demo.controller;

import com.example.demo.dto.UserCarsResponseDTO;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<UserCarsResponseDTO> listAllCars() {
        return carService.listAllCars();
    }

    @PostMapping
    public String insertCar(@RequestBody Car car) {
        return carService.insertCar(car);
    }

    @DeleteMapping
    public String deleteCar(@RequestBody int id) {
        return carService.deleteCar(id);
    }

    @PutMapping
    public String editCar(@RequestBody Car car) {
        return carService.editCar(car);
    }
}
