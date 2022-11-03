package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entites.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserByEmail(String email, String password);
}
