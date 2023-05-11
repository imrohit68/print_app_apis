package com.rohit.apis.printApp.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAlreadyExists extends RuntimeException {
    private final String email;
    private final String username;
    private final String mobileNumber;


    public UserAlreadyExists(String email, String username, String mobileNumber) {
        super(String.format("User already exists with email : %s  , username : %s  , mobileNumber: %s",email,username,mobileNumber));
        this.email = email;
        this.username = username;
        this.mobileNumber = mobileNumber;
    }
}
