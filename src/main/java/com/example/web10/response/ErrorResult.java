package com.example.web10.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResult {

    @Schema(
            example = "404"
    )
    private int status;

    @Schema(
            example = "Not Found"
    )
    private String message;

    @Override
    public String toString() {
        return "ErrorResult{" +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
