package ru.geekbrains.MyWebApplication;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Программа составления списка задач
@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    /**
     * метод получения всех задач
     */

    public  List<Task> getALLTask(){
        return tasks;
    }

    /**
     * метод получения определенной задачи по ее id
     * @param uuid
     * @return метод findFirst выводит первый попавший под параметры элемент
     */
    public Task getTask(UUID uuid){
        return tasks.stream().filter(t -> t.getId().equals(uuid)).findFirst().orElse(null);
    }

    /**
     * метод добавления новой задачи
      */

    public Task addTask(Task task){
        task.setStatus(Task.Status.TO_DO); // добавление к каждой новой задачи статуса автоматически
        tasks.add(task);
        return task;
    }

    /**
     * метод удаления задачи
      */
    public void deleteTask(UUID uuid){
        tasks.removeIf(t -> t.getId().equals(uuid)); // удаление по id, сравниваем id с id из нашей коллекции и удаляем первый попавший элемент
    }

    /**
     * обновление задачи в списке
      */

    public Task updateTask(UUID uuid, Task task){
        Task task1 = getTask(uuid);
        if(task1 != null){
            task1.setDescription(task.getDescription());
            task1.setName(task.getName());
            task1.setStatus(task.getStatus());
            task1.setCompletionTime(task.getCompletionTime());
        }
        return task1;
    }

}
