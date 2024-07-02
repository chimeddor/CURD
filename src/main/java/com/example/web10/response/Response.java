package com.example.web10.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class Response<T> {

    @Schema(
            description = "status",
            example = "200"
    )
    private int status;
    @Schema(
            description = "message",
            example = "OK"
    )
    private String message;
    private T data;
    // 기본 생성자

    // 모든 필드를 초기화하는 생성자
    public Response(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;

    }

    // 게터와 세터
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

