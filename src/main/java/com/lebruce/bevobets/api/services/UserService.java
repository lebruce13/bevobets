package com.lebruce.bevobets.api.services;
import com.lebruce.bevobets.api.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User registerUser(User user);
    Optional<User> findUserByEmail(String email);
    Optional<User> findByUsername(String username);
}
