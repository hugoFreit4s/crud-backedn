package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    List<User> usersList = new ArrayList<>();

    @GetMapping
    public List<User> GetUsers() {
        return usersList;
    }

    @PostMapping
    public List<User> AddUser(@RequestBody User x) {
        usersList.add(x);
        return usersList;
    }

    @DeleteMapping
    public List<User> DeleteUser(@RequestBody String IDToFind) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getID().equals(IDToFind)) {
                usersList.remove(i);
            }
        }
        return usersList;
    }

    @PutMapping
    public List<User> EditUser(@RequestBody User newUser) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getID().equals(newUser.getID())) {
                User userToEdit = usersList.get(i);
                userToEdit.setName(newUser.getName());
                userToEdit.setAge(newUser.getAge());
            }
        }
        return usersList;
    }
}
