package com.evenement.newsweb.controller;

import com.evenement.newsweb.model.News;
import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.NewsRepository;
import com.evenement.newsweb.repository.UserRepository;
import com.evenement.newsweb.service.NewsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.List;

@Controller
public class NewsControllerMVC {
    private UserRepository userRepository;
    private NewsService newsService;
    private NewsRepository newsRepository;

    @Autowired
        NewsControllerMVC(UserRepository userRepository, NewsService newsService, NewsRepository newsRepository) {
        this.userRepository = userRepository;
        this.newsService = newsService;
        this.newsRepository = newsRepository;
    }


    @GetMapping("/createNews")
    public String createNewsObject(Model model) {
        model.addAttribute("newsModel", new News());
        return "addNews";
    }

    @PostMapping("/createNews")
    public String createNews(@ModelAttribute @Valid News newsModel,BindingResult bindingResult, @AuthenticationPrincipal UserDetails currentUser,RedirectAttributes redirectAttr)
    {
            String username = currentUser.getUsername();
            User user = userRepository.findByUsername(username);
            if (bindingResult.hasErrors())
            {
                List<ObjectError> errors = bindingResult.getAllErrors();
                errors.forEach(x->System.out.println(x.getDefaultMessage()));
                return "createNews";
            }else
            {
                newsService.addNews(newsModel,user);
            }
            redirectAttr.addFlashAttribute("message","News został dodany pomyślnie");
            return "redirect:/";


    }
    @GetMapping("/")
    public String getAllNews(Model model, @RequestParam(defaultValue = "0")int pageNumber)
    {
        Page <News> allNews =  newsRepository.findAll(new PageRequest(pageNumber,6));
        model.addAttribute("allNews",allNews);
        return "index";

    }
    @RequestMapping ( path = "showNews/{id}")
    public String getSingleNews(Model model, @PathVariable long id) throws NotFoundException {

            News singleNews = newsRepository.findById(id);
            if (singleNews != null) {
                model.addAttribute("singleNews", singleNews);
                return "showNews";
            }
        throw new NotFoundException("Niestety ale nie można wyświetlić strony");

    }

}
