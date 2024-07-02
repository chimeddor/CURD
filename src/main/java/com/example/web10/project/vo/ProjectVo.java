package com.example.web10.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class ProjectVo {

    @Schema(
            description = "project id",
            example = "1",
            type = "integer"
    )
    @Min(1)
    private int pid;

    @Schema(
            description = "project name",
            example = "big data",
            type = "string",
            maxLength = 50,
            nullable = false
    )
    @Size(min = 1, max = 50)
    private String pname;

    @Schema(
            description = "project start day",
            example = "2024-06-28",
            type = "date",
            nullable = true
    )
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date prStartDate;

    @Schema(
            description = "project end date",
            example = "2024-06-28",
            type = "date",
            nullable = true
    )
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date prEndDate;

    @Schema(
            description = "project desc",
            example = "this project is...",
            type = "string",
            maxLength = 1000,
            nullable = true
    )
    @Size(min = 1, max = 1000)
    private String proDesc;

    @Schema(
            description = "creater id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int crId;

    @Schema(
            description = "update 여부",
            example = "1",
            type = "int",
            nullable = false
        )
    private int chngNm;

    @Schema(
            description = "username",
            example = "chimeddorj",
            type = "string",
            maxLength = 50)
    private String uname;

}
