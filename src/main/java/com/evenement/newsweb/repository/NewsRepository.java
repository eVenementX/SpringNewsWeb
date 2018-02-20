package com.evenement.newsweb.repository;

import com.evenement.newsweb.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    News findById(Long id);
}
