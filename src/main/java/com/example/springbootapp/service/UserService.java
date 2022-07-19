package com.example.springbootapp.service;

import com.example.springbootapp.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    void editUser(User user, long id);

    List<User> getAllUsers();
}
