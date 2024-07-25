package com.intership.task_4.controller;

import com.intership.task_4.model.UserModel;
import com.intership.task_4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login"; // Asegúrate de que login.html exista en src/main/resources/templates
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // Asegúrate de que register.html exista en src/main/resources/templates
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin"; // Asegúrate de que admin.html exista en src/main/resources/templates
    }

    @PostMapping("/block")
    public String blockUsers(@RequestParam List<Long> userIds) {
        for (Long id : userIds) {
            Optional<UserModel> userOptional = userRepository.findById(id);
            userOptional.ifPresent(user -> {
                user.setActive(false);
                userRepository.save(user);
            });
        }
        return "redirect:/admin";
    }

    @PostMapping("/unblock")
    public String unblockUsers(@RequestParam List<Long> userIds) {
        for (Long id : userIds) {
            Optional<UserModel> userOptional = userRepository.findById(id);
            userOptional.ifPresent(user -> {
                user.setActive(true);
                userRepository.save(user);
            });
        }
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteUsers(@RequestParam List<Long> userIds) {
        for (Long id : userIds) {
            userRepository.deleteById(id);
        }
        return "redirect:/admin";
    }
}