package ru.zhumabaev.springcourse.PP311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.zhumabaev.springcourse.PP311.model.User;
import ru.zhumabaev.springcourse.PP311.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUser(ModelMap modelMap) {
        List<User> list = userService.getAllUsers();
        modelMap.addAttribute("list", list);
        return "userList";
    }

    @GetMapping(value = "/new")
    public String addUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/edit/{id}")
    public String update(@ModelAttribute("user") User user,
                             @PathVariable("id") int id) {
        userService.updateUser(user, id);
        return "redirect:/user";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

}
