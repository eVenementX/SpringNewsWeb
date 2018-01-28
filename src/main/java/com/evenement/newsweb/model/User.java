package com.evenement.newsweb.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;
    private String firstName;
    private String lastName;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<UserRole> userRole = new HashSet <>();
    @OneToMany(mappedBy = "user")
    private List<News> news;
    @OneToMany(mappedBy = "user")
    private List<Comment> comment;

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, Set <UserRole> userRole, List <News> news, List <Comment> comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.news = news;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set <UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set <UserRole> userRole) {
        this.userRole = userRole;
    }

    public List <News> getNews() {
        return news;
    }

    public void setNews(List <News> news) {
        this.news = news;
    }

    public List <Comment> getComment() {
        return comment;
    }

    public void setComment(List <Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", news=" + news +
                ", comment=" + comment +
                '}';
    }
}
