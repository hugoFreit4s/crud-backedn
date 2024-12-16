package com.example.demo.service;

import com.example.demo.dto.UserCarsResponseDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.specifications.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponseDTO> getAll() {
        List<User> allUsers = userRepository.findAll();
        List<UserResponseDTO> usersReponse = new ArrayList<>();
        for (User currentUser : allUsers) {
            List<Car> userCars = currentUser.getCars();
            List<UserCarsResponseDTO> userCarsResponseDTO = new ArrayList<>();
            for (Car currentCar : userCars) {
                UserCarsResponseDTO currentCarDTO = new UserCarsResponseDTO(currentCar.getId(), currentCar.getBrand(), currentCar.getModelName(), currentCar.getOwner().getName(), currentCar.getValue(), currentCar.getManufactureYear());
                userCarsResponseDTO.add(currentCarDTO);
            }
            UserResponseDTO userDTO = new UserResponseDTO(currentUser.getID(), currentUser.getName(), currentUser.getGender(), currentUser.getPhone(), currentUser.getAge(), userCarsResponseDTO);
            usersReponse.add(userDTO);
        }
        return usersReponse;
    }

    public Optional<UserResponseDTO> getByID(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User userFound = optionalUser.get();
            List<Car> userCars = userFound.getCars();
            List<UserCarsResponseDTO> userCarsResponseDTO = new ArrayList<>();
            for (Car currentCar : userCars) {
                UserCarsResponseDTO currentCarDTO = new UserCarsResponseDTO(currentCar.getId(), currentCar.getBrand(), currentCar.getModelName(), currentCar.getOwner().getName(), currentCar.getValue(), currentCar.getManufactureYear());
                userCarsResponseDTO.add(currentCarDTO);
            }
            UserResponseDTO response = new UserResponseDTO(userFound.getID(), userFound.getName(), userFound.getGender(), userFound.getPhone(), userFound.getAge(), userCarsResponseDTO);
            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }

    public String add(User user) {
        userRepository.save(user);
        return "User " + user.getName() + " added successfully!";
    }

    public String delete(int id) {
        String userName = userRepository.getReferenceById(id).getName();
        userRepository.deleteById(id);
        return "User " + userName + " deleted successfully!";
    }

    public String edit(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getID());
        if (optionalUser.isPresent()) {
            User newUser = optionalUser.get();
            newUser.setName(user.getName());
            newUser.setBirthDate(user.getBirthDate());
            newUser.setPhone(user.getPhone());
            userRepository.save(newUser);
            return "User edited:\nNew data:\n" + newUser.getName() + ", " + newUser.getBirthDate() + "\n" + newUser.getPhone();
        } else {
            return "User not found!";
        }
    }

    public List<UserResponseDTO> filter(String gender, String age) {
        Specification<User> specification = UserSpecification.filter(gender, age);
        List<User> users = userRepository.findAll(specification);
        List<UserResponseDTO> usersDTO = new ArrayList<>();
        for (User currentUser : users) {
            List<UserCarsResponseDTO> currentUserCarsDTO = new ArrayList<>();
            for (Car currentCar : currentUser.getCars()) {
                UserCarsResponseDTO currentCarDTO = new UserCarsResponseDTO(currentCar.getId(), currentCar.getBrand(), currentCar.getModelName(), currentCar.getOwner().getName(), currentCar.getValue(), currentCar.getManufactureYear());
                currentUserCarsDTO.add(currentCarDTO);
            }
            UserResponseDTO currentUserDTO = new UserResponseDTO(currentUser.getID(), currentUser.getName(), currentUser.getGender(), currentUser.getPhone(), currentUser.getAge(), currentUserCarsDTO);
            usersDTO.add(currentUserDTO);
        }
        return usersDTO;
    }
}
