package org.ncu.hirewheels.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.ncu.hirewheels.entites.User;
import org.ncu.hirewheels.exception.UserNotFoundException;
import org.ncu.hirewheels.repository.UserRespository;
import org.ncu.hirewheels.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRespository userRespository;

    public UserServiceImpl(UserRespository userRespository) {
        super();
        this.userRespository = userRespository;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userRespository.save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRespository.findAll();
    }

    @Override
    @Transactional
    public User getUserByEmail(String email, String password) {

        User user = userRespository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User dont exist ");
        }

        if (!password.matches(user.getPassword())) {
            throw new UserNotFoundException("Password");

        }

        return user;
    }

}
