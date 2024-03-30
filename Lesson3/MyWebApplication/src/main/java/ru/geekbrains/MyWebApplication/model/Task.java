package ru.geekbrains.MyWebApplication;
/**
 *  класс UUID гененирует автоматически id
 */

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * класс задача включает в себя id, имя и описание, статус и время окончания задачи
 */
public class Task {
    private UUID id;
    private String name;
    private String description;
    private Status status;
    //  поле содержащее информацию о времени окончания задачи
    private LocalDateTime completionTime;

    private Priority priority;

    /**
     *  конструктор
     * @param name
     * @param description
     */
    public Task(String name, String description, Priority priority) {
        this.id = UUID.randomUUID(); // указывает что id проставляется автоматически
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    public LocalDateTime getCompletionTime() {

        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {

        this.completionTime = completionTime;
    }
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * enum используется для перечисления чего либо. Мы прописываем конечное кол во вариантов ответа и потом вызывем его как поле
     */
    public enum Status{
        TO_DO,
        IN_PROGRESS,
        DONE
    }

    public enum Priority{
        LOW,
        MEDIUM,
        HIGH
    }


}
