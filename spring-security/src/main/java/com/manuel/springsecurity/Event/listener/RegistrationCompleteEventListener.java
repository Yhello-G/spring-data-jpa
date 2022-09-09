package com.manuel.springsecurity.Event.listener;

import com.manuel.springsecurity.Event.UserRegistrationComplete;
import com.manuel.springsecurity.entity.User;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<UserRegistrationComplete> {
    @Override
    public void onApplicationEvent(UserRegistrationComplete userEvent) {
    // create the verification token for the user
        User user = userEvent.getUser();
        String token = UUID.randomUUID().toString();
    }
}
