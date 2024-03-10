package ru.geekbrains.example3sem3homeTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.example3sem3homeTask.domen.User;
import ru.geekbrains.example3sem3homeTask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort") // localhost:8080/tasks/sort
    public List<User> sortUsersByAge(){
        return service.sortUsersByAge(service.getUserRepository().getUsers());
    }
    //метод filterUsersByAge
    @GetMapping("/filter/{age}") // localhost:8080/tasks/filter/30
    public List<User> filterUsersByAge(@PathVariable int age){
        return service.filterUsersByAge(service.getUserRepository().getUsers(), age);

    }


    //метод calculateAverageAge - среднее значение по возрасту
    @GetMapping("/calc") // localhost:8080/tasks/calc
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }


}
