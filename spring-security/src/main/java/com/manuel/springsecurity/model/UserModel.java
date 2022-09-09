package com.manuel.springsecurity.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserModel {
    private String firstName;
    private  String lastName;
    private String email;
    private String password;
    private String matchingPasswd;
}
