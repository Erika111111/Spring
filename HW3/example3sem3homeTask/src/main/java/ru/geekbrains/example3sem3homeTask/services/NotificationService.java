package ru.geekbrains.example3sem3homeTask.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.example3sem3homeTask.domen.User;

/**
 * класс служба уведомлений
 */
@Service
public class NotificationService {
    /**
     * метод сообщение пользователю
     * @param user пользователь
     */
    public void notifyUser(User user){

        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * метод отправки уведомления
     * @param s
     */
    public void sendNotification(String s){

        System.out.println(s);
    }
}
