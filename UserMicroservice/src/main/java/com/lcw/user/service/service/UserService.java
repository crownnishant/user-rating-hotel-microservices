package com.lcw.user.service.service;

import com.lcw.user.service.entity.User;

import java.util.List;

public interface UserService {

    //create User
    User saveUser(User user);

    //get all the users
    List<User> getAllUser();

    //get single user
    User getUser(String userId);

    //delete user
    //update user

}
