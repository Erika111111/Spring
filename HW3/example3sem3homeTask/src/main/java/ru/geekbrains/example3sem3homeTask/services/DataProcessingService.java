package ru.geekbrains.example3sem3homeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.example3sem3homeTask.domen.User;
import ru.geekbrains.example3sem3homeTask.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * класс обработки данных
 */
@Service
public class DataProcessingService {
    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public List<User> sortUsersByAge(List<User> users){
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }
    public List<User>filterUsersByAge(List<User> users, int age){
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User>users){
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
    public void addUserToList(User user){

        userRepository.getUsers().add(user);
    }
}
