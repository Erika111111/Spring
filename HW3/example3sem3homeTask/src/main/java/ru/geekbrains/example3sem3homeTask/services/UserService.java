package ru.geekbrains.example3sem3homeTask.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.example3sem3homeTask.domen.User;

/**
 * класс занимается созданием пользователя
  */
@Service
public class UserService {
    @Autowired
    private NotificationService notificationService;


    /**
     * конструктор
     * @param notificationService
     */
//    public UserService(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }

    /**
     * метод создания пользователя
     * @param name имя
     * @param age возраст
     * @param email почта
     * @return
     */
    public User createUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // отправка уведомления о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
