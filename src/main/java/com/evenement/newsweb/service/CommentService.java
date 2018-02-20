package com.evenement.newsweb.service;

import com.evenement.newsweb.model.Comment;
import com.evenement.newsweb.model.News;
import com.evenement.newsweb.model.User;
import com.evenement.newsweb.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;

     CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(News news, User user, Comment comment)
    {
        comment.setNews(news);
        comment.setUser(user);
        commentRepository.save(comment);
    }
}
