package com.example.demo.service;

import com.example.demo.dto.UserCarsResponseDTO;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<UserCarsResponseDTO> listAllCars() {
        List<Car> allCars = carRepository.findAll();
        List<UserCarsResponseDTO> carsResponseDTO = new ArrayList<>();
        for (Car currentCar : allCars) {
            User currentOwner = currentCar.getOwner();
            UserCarsResponseDTO carDTO = new UserCarsResponseDTO(currentCar.getId(), currentCar.getBrand(), currentCar.getModelName(), currentOwner.getName(), currentCar.getValue());
            carsResponseDTO.add(carDTO);
        }
        return carsResponseDTO;
    }

    public String insertCar(Car car) {
        carRepository.save(car);
        return car.getBrand() + " " + car.getModelName() + " " + car.getOwner().getName();
    }

    public String deleteCar(int id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            carRepository.delete(car);
            return "Car " + car.getBrand() + " " + car.getModelName() + " deleted";
        } else {
            return "Not found!";
        }
    }
}
