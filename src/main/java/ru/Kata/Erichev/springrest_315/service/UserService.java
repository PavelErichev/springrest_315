package ru.Kata.Erichev.springrest_315.service;

import ru.Kata.Erichev.springrest_315.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user, String[] role);

    boolean deleteUser(long id);
}