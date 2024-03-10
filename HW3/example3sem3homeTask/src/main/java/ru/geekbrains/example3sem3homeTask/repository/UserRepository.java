package ru.geekbrains.example3sem3homeTask.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.example3sem3homeTask.domen.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {

        return users;
    }

    public void setUsers(List<User> users) {

        this.users = users;
    }
}
