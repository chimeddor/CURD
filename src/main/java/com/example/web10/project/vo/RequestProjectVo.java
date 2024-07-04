package com.example.web10.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
//@Builder
public class RequestProjectVo {

    @Schema(
            description = "project name",
            example = "machine learning",
            type = "string",
            nullable = false
    )
    @NotNull
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

    @Schema(
            description = "project end date",
            example = "2024-07-04T07:28:58.595Z",
            type = "date",
            nullable = true
    )
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date prEndDate;

    @Schema(
            description = "creater id",
            example = "1",
            type = "integer",
            nullable = false
    )
    @NotNull
    @Min(1)
    private int crId;
}
