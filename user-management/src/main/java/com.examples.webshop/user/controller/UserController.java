package com.examples.webshop.user.controller;


import com.examples.webshop.user.exception.UserNotFoundException;
import com.examples.webshop.user.model.User;
import com.examples.webshop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createOrUpdateUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable(name="user_id") String id){
        try {
            User user = userService.fetchUser(Integer.valueOf(id));
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("/user/{user_id}")
    public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable(name="user_id") String id) {
        return new ResponseEntity<>(userService.createOrUpdateUser(user),HttpStatus.OK);
    }

    @DeleteMapping("/user/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name="user_id") String id){
        try{
            String result = userService.deleteUser(Integer.valueOf(id));
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch(UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
