package com.example.web10.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ValidErrorResponse {
    @Schema(
            example = "Invalid input value"
    )
    private String message;

    @Schema(
            example = "400"
    )
    private int status;
    private List<FieldError> errors;

    private ValidErrorResponse(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus().value();
    }

    private ValidErrorResponse(final ErrorCode code, final List<FieldError> errors) {
        this.message = code.getMessage();
        this.status = code.getStatus().value();
        this.errors = errors;
    }
//
//    public static ValidErrorResponse of(final ErrorCode code) {
//        return new ValidErrorResponse(code);
//    }

    public static ValidErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
        return new ValidErrorResponse(code, FieldError.of(bindingResult));
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        @Schema(
                example = "uname"
        )
        private String field;

        @Schema(
                example = "a"
        )
        private String value;

        private FieldError(final String field, final String value) {
            this.field = field;
            this.value = value;
        }

        private static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString()))
                    .collect(Collectors.toList());
        }
    }
}
