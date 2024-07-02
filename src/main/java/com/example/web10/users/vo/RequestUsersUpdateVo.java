package com.example.web10.users.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUsersUpdateVo {

    @Schema(
            description = "id",
            example = "1",
            minLength = 1,
            nullable = false
    )
    @Min(1)
    private int idN;

    @Schema(
            description = "사용자 이름",
            example = "chimeddorj",
            type = "string",
            maxLength = 100,
            nullable = true
    )

    @Size(min=5, max=100)
    private String uname;

    @Schema(
            description = "phone 번호",
            example = "23982938923",
            type = "string",
            nullable=true
    )
    @Size(min = 8, max = 20)
    private String phone;

    @Schema(
            description = "나이",
            example = "24",
            type = "int",
            nullable = true
    )
    @Max(200)
    private int age;

}
