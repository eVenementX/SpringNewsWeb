package com.evenement.newsweb.controller;

import com.evenement.newsweb.model.Comment;
import com.evenement.newsweb.model.News;
import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.CommentRepository;

import com.evenement.newsweb.repository.NewsRepository;
import com.evenement.newsweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/news")
public class CommentControllerMVC {
    private CommentService commentService;
    private NewsRepository newsRepository;

    @Autowired
    CommentControllerMVC(CommentService commentService, NewsRepository newsRepository)
    {
        this.commentService=commentService;
        this.newsRepository = newsRepository;
    }

    @PostMapping(path = "/{id}")
    public String addComment(@ModelAttribute @Valid Comment commentModel, @PathVariable Long id)
    {
        News news = newsRepository.findById(id);
        commentService.addComment(news,null,commentModel);
        return "redirect:/";
    }
}
