package com.evenement.newsweb.service;


import com.evenement.newsweb.model.User;
import com.evenement.newsweb.model.UserRole;
import com.evenement.newsweb.repository.UserRepository;
import com.evenement.newsweb.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getUserRole().add(defaultRole);
        userRepository.save(user);
    }

}