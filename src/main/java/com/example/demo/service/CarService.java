package com.example.demo.service;

import com.example.demo.dto.UserCarsResponseDTO;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;

    public List<UserCarsResponseDTO> listAllCars() {
        List<Car> allCars = carRepository.findAll();
        List<UserCarsResponseDTO> carsResponseDTO = new ArrayList<>();
        for (Car currentCar : allCars) {
            User currentOwner = currentCar.getOwner();
            UserCarsResponseDTO carDTO = new UserCarsResponseDTO(currentCar.getId(), currentCar.getBrand(), currentCar.getModelName(), currentOwner.getName(), currentCar.getValue(), currentCar.getManufactureYear());
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

    public String editCar(Car newCar) {
        Optional<Car> optionalCar = carRepository.findById(newCar.getId());
        if (optionalCar.isPresent()) {
            Car currentCar = optionalCar.get();
            currentCar.setBrand(newCar.getBrand());
            currentCar.setValue(newCar.getValue());
            currentCar.setOwner(newCar.getOwner());
            currentCar.setModelName(newCar.getModelName());
            currentCar.setManufactureYear(newCar.getManufactureYear());
            carRepository.save(currentCar);
            return "Success!";
        } else {
            return "Error";
        }
    }

    public List<UserCarsResponseDTO> getCarByBrand(String brand) {
        List<UserCarsResponseDTO> filteredCars = new ArrayList<>();
        for (Car currentCar : carRepository.findAll()) {
            if (currentCar.getBrand().equals(brand)) {
                User currentOwner = currentCar.getOwner();
                UserCarsResponseDTO carDTO = new UserCarsResponseDTO(currentCar.getId(), currentCar.getBrand(), currentCar.getModelName(), currentOwner.getName(), currentCar.getValue(), currentCar.getManufactureYear());
                filteredCars.add(carDTO);
            }
        }
        return filteredCars;
    }
}
