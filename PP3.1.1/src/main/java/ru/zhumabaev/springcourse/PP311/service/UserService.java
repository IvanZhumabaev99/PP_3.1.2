package ru.zhumabaev.springcourse.PP311.service;

import ru.zhumabaev.springcourse.PP311.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(int id);

    User updateUser(User user, int id);

    void deleteUser(int id);

}
