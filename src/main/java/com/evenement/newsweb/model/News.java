package com.evenement.newsweb.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class News {
    @Id
    @GeneratedValue
    @Column(name = "id_news")
    private Long id;
    @NotEmpty

    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String content;
    private Timestamp timestamp;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "news")
    private List<Comment> comment;

    public News() {
    }

    public News(String title, String description, String content, Timestamp timestamp, User user, List <Comment> comment) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List <Comment> getComment() {
        return comment;
    }

    public void setComment(List <Comment> comment) {
        this.comment = comment;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", comment=" + comment +
                ", timestamp=" + timestamp +
                '}';
    }


}
