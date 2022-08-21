package com.demoConnection.Prometheus.controller;

import com.demoConnection.Prometheus.model.User;
import com.demoConnection.Prometheus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController { //Post and Get Request from Client
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Valid @NotNull @RequestBody User user){
        userService.insertUser(user);
    }

    @GetMapping
    public List<User>getAllUsers(){//calling my service from endpoint to get users
        return userService.selectAllUsers();
    }

    @GetMapping(path = "{id}") //creates a path
    public User getUserByID(@PathVariable("id") UUID id){ //turn the path into a uid
        return userService.selectUserById(id)
                .orElse(null);//TODO return 404 user id not found
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserByID(@PathVariable("id") UUID id){
        userService.deleteUserById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,
                             @Valid @NotNull @RequestBody User userToUpdate  ){
            userService.updateUserById(id, userToUpdate);
    }
}
