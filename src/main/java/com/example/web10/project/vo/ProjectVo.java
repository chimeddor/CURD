package com.example.web10.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class ProjectVo {

    @Schema(
            description = "project id",
            example = "1",
            type = "integer",
            nullable = false
    )
    private int pid;

    @Schema(
            description = "project name",
            example = "machine learning",
            type = "string",
            maxLength = 50,
            nullable = false
    )
    private String pname;

    @Schema(
            description = "project start day",
            example = "2024-07-04T07:28:58.595Z",
            type = "date",
            nullable = false
    )
    private Date prStartDate;

    @Schema(
            description = "project end date",
            example = "2024-07-04T07:28:58.595Z",
            type = "date",
            nullable = true
    )
    private Date prEndDate;

    @Schema(
            description = "project desc",
            example = "machine learning is",
            type = "string",
            maxLength = 1000,
            nullable = true
    )
    private String proDesc;

    @Schema(
            description = "creater id",
            example = "1",
            type = "integer",
            nullable = false
    )
    private int crId;

    @Schema(
            description = "update 여부",
            example = "1",
            type = "integer",
            nullable = false
        )
    private int chngNm;

    @Schema(
            description = "update user id",
            example = "1",
            type = "integer",
            nullable = true
    )
    private Integer updId;

    @Schema(
            description = "updated date",
            example = "2024-07-04T07:28:58.595Z",
            type = "date",
            nullable = true
    )
    private Date updDte;

    @Schema(
            description = "username",
            example = "chimeddorj",
            type = "string",
            maxLength = 50,
            nullable = false
    )

    private String uname;

}
