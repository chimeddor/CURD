package com.example.web10.project.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestProjectIdVo {

    @Schema(
            description = "project id",
            example = "1",
            type = "integer",
            nullable = false
    )
    @NotNull
    @Min(1)
    private int pid;
}
