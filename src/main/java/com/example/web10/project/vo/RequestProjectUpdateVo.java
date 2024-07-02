package com.example.web10.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestProjectUpdateVo {

    @Schema(
            description = "project id",
            example = "1",
            type = "integer",
            nullable = false
    )
    @Min(1)
    private int pid;

    @Schema(
            description = "project name",
            example = "machine learning",
            type = "string",
            maxLength = 50,
            nullable = true
    )
    @Size(min = 5, max = 50)
    private String pname;

    @Schema(
            description = "project desc",
            example = "machine learning is",
            type = "string",
            maxLength = 1000,
            nullable = true
    )
    @Size(min = 1, max = 1000)
    private String proDesc;

}
