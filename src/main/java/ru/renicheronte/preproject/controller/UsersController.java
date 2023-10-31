package ru.renicheronte.preproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.renicheronte.preproject.model.User;
import ru.renicheronte.preproject.service.UserService;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String showUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "show_user";
    }

    @GetMapping("/users/create-new")
    public String showUserCreationPage(@ModelAttribute("user") User user) {
        return "create_new_user";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String showUserUpdatePage(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit_user";
    }

    @PatchMapping("/users/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @PathVariable("id") int id) {
        userService.updateUserById(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
