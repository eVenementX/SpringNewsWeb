package com.evenement.newsweb.controller;


import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LoginController {
    private UserRepository userRepository;
    @Autowired
    LoginController(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/")
    public String dashboardPageList(@AuthenticationPrincipal UserDetails currentUser ) {
        if (currentUser != null)
        {
            String username = currentUser.getUsername();
            User user = userRepository.findByUsername(username);
            System.out.println(user);
        }

           return "index";
    }
}
