package com.example.web10.response.handler;

import com.example.web10.response.ErrorCode;
import com.example.web10.response.ErrorResult;
import com.example.web10.response.NotFoundException;
import com.example.web10.response.ValidErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends ValidErrorResponse {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        final var response = ValidErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, ErrorCode.INVALID_INPUT_VALUE.getStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResult> notFoundException(NotFoundException e){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setStatus(e.getStatus());
        errorResult.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorResult);
    }

}
