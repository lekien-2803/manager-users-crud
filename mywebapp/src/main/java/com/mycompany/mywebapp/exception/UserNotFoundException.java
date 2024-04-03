package com.mycompany.mywebapp.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

}
