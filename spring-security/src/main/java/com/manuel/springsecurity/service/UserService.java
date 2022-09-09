package com.manuel.springsecurity.service;

import com.manuel.springsecurity.entity.User;
import com.manuel.springsecurity.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(UserModel userModel);
}
