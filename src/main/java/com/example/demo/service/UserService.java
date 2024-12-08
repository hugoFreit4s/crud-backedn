package com.example.demo.service;

import com.example.demo.dto.UserCarsDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<UserResponseDTO> getByID(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User userFound = optionalUser.get();
            UserResponseDTO response = new UserResponseDTO(userFound.getID(), userFound.getName());
            for (Car currentCar : userFound.getCars()) {
                UserCarsDTO carDTO = new UserCarsDTO(currentCar.getId(), currentCar.getName());
                response.addCar(carDTO);
            }
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
            newUser.setAge(user.getAge());
            newUser.setPhone(user.getPhone());
            userRepository.save(newUser);
            return "User edited:\nNew data:\n" + newUser.getName() + ", " + newUser.getAge() + "\n" + newUser.getPhone();
        } else {
            return "User not found!";
        }
    }
}
