package ru.geekbrains.MyWebApplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * метод получения списка всех задач
      */
    @GetMapping()
    public List<Task>getAllTasks(){
        return taskService.getALLTask();
    }

    /**
     * метод получения задачи по id
     * @param uuid
     * @return
     */
    @GetMapping("/{id}")
    public Task getById(@PathVariable UUID uuid){

        return taskService.getTask(uuid);
    }

    /**
     * метод изменения задачи
     * @param task
     * @return
     */
    @PostMapping()
    public Task addById(@RequestBody Task task){

        return taskService.addTask(task);
    }

    /**
     * метод обновления задачи
     * @param uuid
     * @return
     */
    @PutMapping("/{id}")
    public Task updateById(@PathVariable UUID uuid, @RequestBody Task task){

        return taskService.updateTask(uuid,task);
    }

    /**
     * метод удаления задач
     * @param uuid
     * @return
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID uuid){

        taskService.deleteTask(uuid);
    }

}
