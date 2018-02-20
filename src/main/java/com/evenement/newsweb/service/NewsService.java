package com.evenement.newsweb.service;

import com.evenement.newsweb.model.News;
import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.NewsRepository;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NewsService {
    private NewsRepository newsRepository;

    @Autowired
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
    public News addNews (News news, User user)
    {
        News newNews = news;
        newNews.setTimestamp(new Timestamp(new Date().getTime()));
        newNews.setUser(user);
        newsRepository.save(newNews);
        return newNews;
    }
}
