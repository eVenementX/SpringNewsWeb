package com.evenement.newsweb.controller;

import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.UserRepository;
import com.evenement.newsweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private UserRepository userRepository;
    private UserService userService;
    @Autowired
    RegisterController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @GetMapping
    public String createUserObject(Model model)
    {
        model.addAttribute("userObject", new User());
        return "register";
    }
    @PostMapping
    public String registerUser(@ModelAttribute @Valid User user, BindingResult bindResult )
    {
        if (bindResult.hasErrors())
            return "registerForm";
        else
        {
            userService.addWithDefaultRole(user);
        }
        return "index";
    }
}
