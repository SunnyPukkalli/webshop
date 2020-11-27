package com.examples.webshop.user.service;

import com.examples.webshop.user.exception.UserNotFoundException;
import com.examples.webshop.user.model.User;

import java.util.Optional;

public interface UserService {

    User createOrUpdateUser(User user);

    User fetchUser(Integer userId) throws UserNotFoundException;

    Optional<User> fetchUserByEmail(String email);

    String deleteUser(Integer userId) throws UserNotFoundException;



}
