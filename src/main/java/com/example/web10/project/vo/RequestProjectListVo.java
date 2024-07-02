package com.example.web10.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
public class RequestProjectListVo {

    @Schema(
            description = "project name",
            example = "big data",
            type = "string",
            maxLength = 50,
            nullable = true
    )
    @Size(min = 1, max = 50)
    private String pname;

    @Schema(
            description = "project desc",
            example = "this project is...",
            type = "string",
            maxLength = 1000,
            nullable = true
    )
    @Size(min = 1, max = 1000)
    private String proDesc;
}
