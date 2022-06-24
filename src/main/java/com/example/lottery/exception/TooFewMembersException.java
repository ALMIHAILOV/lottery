package com.example.lottery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TooFewMembersException extends RuntimeException{
    public TooFewMembersException(){
        super("Too few members");
    }
}
