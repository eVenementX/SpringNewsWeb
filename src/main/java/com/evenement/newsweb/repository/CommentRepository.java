package com.evenement.newsweb.repository;

import com.evenement.newsweb.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
