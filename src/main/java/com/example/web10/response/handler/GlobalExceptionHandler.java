package com.example.web10.response.handler;

import com.example.web10.response.ErrorCode;
import com.example.web10.response.ErrorResult;
import com.example.web10.response.NotFoundException;
import com.example.web10.response.ValidErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//주로 json, xml 반환하는 RestController에서 사용. @RestController
//@RestControllerAdvice

//html 반환하는 Controller에서 사용.
@ControllerAdvice
public class GlobalExceptionHandler extends ValidErrorResponse {

    //이 메서드가 유효성 검사 오류가 발생할 때 호출되어 적절한 응답을 생성하고 반환.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // MethodArgumentNotValidException을 인자로 받아, ResponseEntity<ValidErrorResponse>을 반환.
    public ResponseEntity<ValidErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        //에러 응답 객체/
        //ValidErrorResponse 클래스의 of 메서드를 호출
        //ErrorCode 과 e.getBindingResult을 인자로 받 ValidErrorResponse 겍체를 생성.
        //e.getBindingResult은 유효 검사 시 실패에 대한 상세 정보 예: (1 errors, 2 errors)
        // response-> com.example.web10.response.ValidErrorResponse@114e415

        final var response = ValidErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        // ErrorCode.INVALID_INPUT_VALUE.getStatus() -> 400 BAD_REQUEST
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
