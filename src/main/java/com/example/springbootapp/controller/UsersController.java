package com.example.springbootapp.controller;

import com.example.springbootapp.service.UserService;
import com.example.springbootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {
    private final UserService userDao;

    @Autowired
    public UsersController(UserService userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public String showUsers(ModelMap model) {
        model.addAttribute("usersList", this.userDao.getAllUsers());
        return "users";
    }

    @GetMapping("users/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        this.userDao.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String showUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", this.userDao.getUser(id));
        return "show";
    }

    @GetMapping("users/{id}/update")
    public String getUpdateUserForm(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", this.userDao.getUser(id));
        return "updateUser";
    }

    @PatchMapping("users/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        this.userDao.editUser(user, id);
        return "show";
    }

    @DeleteMapping("users/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        this.userDao.deleteUser(id);
        return "redirect:/users";
    }
}