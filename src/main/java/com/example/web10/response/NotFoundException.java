package com.example.web10.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException{

    private final int status;

    public NotFoundException(String message, int status){
        super(message);
        this.status = status;
    }

}
