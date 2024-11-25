package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    List<User> usersList = new ArrayList<>();

    public UserController() {
        populateUsersList();
    }

    private void populateUsersList() {
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Eve", "Charlie", "Dave", "Grace", "Hugo", "Ivy"};
        String[] lastNames = {"Smith", "Doe", "Johnson", "Brown", "Williams", "Jones", "Miller", "Davis", "Garcia", "Martinez"};
        Random random = new Random();

        for (int i = 0; i < 150; i++) {
            String id = UUID.randomUUID().toString();
            String name = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
            int age = random.nextInt(50) + 18;
            usersList.add(new User(id, name, age));
        }
    }

    @GetMapping
    public List<User> GetALl() {
        return usersList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //STATUS 201
    public User Add(@RequestBody User userToAdd) {
        //Gerar ID aqui
        usersList.add(userToAdd);
        return userToAdd; //Retornar usuário completo
    }

    @DeleteMapping
    public List<User> Delete(@RequestBody String IDToFind) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getID().equals(IDToFind)) {
                usersList.remove(i);
            }
        }
        return usersList;
    }

    @PutMapping
    public List<User> Edit(@RequestBody User newUser) {
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
