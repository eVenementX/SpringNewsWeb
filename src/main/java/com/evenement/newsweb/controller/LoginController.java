package com.evenement.newsweb.controller;

import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LoginController {
    private UserRepository userRepository;
    LoginController(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Autowired
            @GetMapping("/login")
            public String login()
    {
        return "login";
    }
   @RequestMapping("/login")
    public void createUserObject(Principal principal, Model model)
   {
       String username = principal.getName();
      User user = userRepository.findByUsername(username);
       model.addAttribute("user",user);
   }

}
