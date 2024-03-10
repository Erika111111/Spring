package ru.geekbrains.example3sem3homeTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.example3sem3homeTask.domen.User;
import ru.geekbrains.example3sem3homeTask.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;
    @GetMapping
    public List<User> userList(){

        return service.getDataProcessingService().getUserRepository().getUsers();
    }
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getUserRepository().getUsers().add(user);
        return "User added from body!";

    }




}
