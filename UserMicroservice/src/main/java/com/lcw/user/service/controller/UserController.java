package com.lcw.user.service.controller;

import com.lcw.user.service.entity.User;
import com.lcw.user.service.payload.ResponseDTO;
import com.lcw.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private final  UserService userService;

    //create
    @PostMapping
    public ResponseEntity<ResponseDTO<User>> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        ResponseDTO<User> response = ResponseDTO.<User>builder()
                .message("User created successfully")
                .data(savedUser)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDTO<User>> getSingleUser(@PathVariable String userId){
        User user=userService.getUser(userId);
        ResponseDTO<User> response=ResponseDTO.<User>builder()
                .message("User fetched successfully")
                .data(user)
                .build();
        return ResponseEntity.ok(response);
    }

    //get all users
    @GetMapping("")
    public ResponseEntity<ResponseDTO<List<User>>> getAllUsers(){
        List<User> users=userService.getAllUser();
        ResponseDTO<List<User>> response=ResponseDTO.<List<User>>builder()
                .message("User fetched successfully")
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }
}