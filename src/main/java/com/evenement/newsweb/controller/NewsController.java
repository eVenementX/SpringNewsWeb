package com.evenement.newsweb.controller;

import com.evenement.newsweb.model.News;
import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.NewsRepository;
import com.evenement.newsweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NewsController {
    private NewsRepository newsRepository;
    private NewsService newsService;
    @Autowired
    NewsController(NewsRepository newsRepository)
    {
        this.newsRepository=newsRepository;
    }
    @GetMapping("/createNews")
    public String createNewsObject(Model model)
    {
        model.addAttribute("news", new News());
        return "createNews";
    }
    @PostMapping("/createNews")
    public String createNews(@ModelAttribute @Valid News news,@ModelAttribute User user, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "createNews";
        }else
        {
            newsService.addNews(news,user);
        }
        return "index";
    }
}
