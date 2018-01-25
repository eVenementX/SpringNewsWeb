package com.evenement.newsweb.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String content;
    @NotEmpty
    @OneToOne
    private User user;
    @NotEmpty
    @ManyToOne
    private News news;
}
