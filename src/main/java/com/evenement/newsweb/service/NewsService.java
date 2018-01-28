package com.evenement.newsweb.service;

import com.evenement.newsweb.model.News;
import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class NewsService {
    private NewsRepository newsRepository;

    @Autowired
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
    public News addNews (News news, User user)
    {
        News newNews = news;
        newNews.setUser(user);
        newsRepository.save(newNews);
        return newNews;
    }
}
