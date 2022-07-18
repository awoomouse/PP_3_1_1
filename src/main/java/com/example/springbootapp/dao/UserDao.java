package com.example.springbootapp.dao;

import com.example.springbootapp.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    void editUser(User user, long id);

    List<User> getAllUsers();
}
