package ru.geekbrains.example3sem3homeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.example3sem3homeTask.domen.User;

@Service
public class RegistrationService {
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private DataProcessingService dataProcessingService;
    public DataProcessingService getDataProcessingService(){
        return dataProcessingService;
    }
    // метод processRegistration
    public void processRegistration(String name, int age, String email){
        /**
         * создаем пользователя из параметров метода
         */
        User user = userService.createUser(name, age, email);
        /**
         * созданный пользователь добавляется в репозиторий
         */
        dataProcessingService.addUserToList(user);
        /**
         * с помощью notificationService выводится сообщение в консоль
         */
        notificationService.notifyUser(user);


    }
}
