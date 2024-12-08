package com.example.demo.controller;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
        //TODO
    }

    @GetMapping("/{id}")
    public UserResponseDTO getByID(@PathVariable int id) {
        var response = userService.getByID(id);
        return response.get();
        //TODO: Resolver endpoint
    }

    @PostMapping
    public String add(@RequestBody User user) {
        return userService.add(user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return userService.delete(id);
    }

    @PutMapping("/{id}")
    public String edit(@PathVariable int id, @RequestBody User user) {
        return userService.edit(user) + "\nID -> " + id;
    }
}
