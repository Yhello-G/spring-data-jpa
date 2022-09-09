package com.manuel.springsecurity.Event;

import com.manuel.springsecurity.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class UserRegistrationComplete extends ApplicationEvent {


    private User user;
    private String applicationUrl;
    public  UserRegistrationComplete(User user, String applicationUrl){
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
