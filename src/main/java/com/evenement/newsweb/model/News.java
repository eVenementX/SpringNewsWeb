package com.evenement.newsweb.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class News {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String content;
    @ManyToOne
    private User user;
    @OneToMany(fetch = FetchType.EAGER)
    private Comment comment;
}
