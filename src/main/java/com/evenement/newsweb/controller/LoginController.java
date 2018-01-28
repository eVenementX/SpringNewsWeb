package com.evenement.newsweb.controller;

import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {
    private UserRepository userRepository;
    @Autowired
    LoginController(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @GetMapping("/login")
    public void loggedUserObject(Principal principal, Model model)
    {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        model.addAttribute("user",user);

    }
}
