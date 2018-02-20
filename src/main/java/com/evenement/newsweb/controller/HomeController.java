package com.evenement.newsweb.controller;


import com.evenement.newsweb.model.News;
import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.NewsRepository;
import com.evenement.newsweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {
    private UserRepository userRepository;
    private NewsRepository newsRepository;
    @Autowired
    public void HomeController(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Autowired
    HomeController(NewsRepository newsRepository)
    {
        this.newsRepository = newsRepository;
    }


    @RequestMapping("/")
    public String createUserObject(@AuthenticationPrincipal UserDetails currentUser, Model model) {
        if (currentUser != null)
        {
            String username = currentUser.getUsername();
            User user = userRepository.findByUsername(username);
            model.addAttribute("user", user);
            System.out.println(user);
            }

           return "index";
    }
}
