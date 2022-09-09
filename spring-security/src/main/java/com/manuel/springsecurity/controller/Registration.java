package com.manuel.springsecurity.controller;

import com.manuel.springsecurity.Event.UserRegistrationComplete;
import com.manuel.springsecurity.entity.User;
import com.manuel.springsecurity.model.UserModel;
import com.manuel.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registration {

    @Autowired
 private UserService userService;
private ApplicationEventPublisher ap;
@RequestMapping("/register")
public String registerUser(@RequestBody UserModel userModel){
    User user = userService.registerUser(userModel);
    ap.publishEvent(new UserRegistrationComplete(user, "url"));

    return "Success";
}


}
