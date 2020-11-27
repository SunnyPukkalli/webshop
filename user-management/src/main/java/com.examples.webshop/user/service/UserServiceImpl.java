package com.examples.webshop.user.service;

import com.examples.webshop.user.exception.UserNotFoundException;
import com.examples.webshop.user.model.User;
import com.examples.webshop.user.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final String USER_NOT_FOUND_MESSAGE = "User does not exist in the system";
    private static final String USER_DELETED_MESSAGE = "User removed Successfully";

    @Override
    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User fetchUser(Integer userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE));
    }

    @Override
    public Optional<User> fetchUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String deleteUser(Integer userId) throws UserNotFoundException {
        try{
            userRepository.deleteById(userId);
            return USER_DELETED_MESSAGE;
        } catch( EmptyResultDataAccessException exception) {
            throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
    }
}
