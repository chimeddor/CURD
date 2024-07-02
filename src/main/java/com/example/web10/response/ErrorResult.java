package com.example.web10.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResult{

    private int status;
    private String message;

    @Override
    public String toString() {
        return "ErrorResult{" +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
