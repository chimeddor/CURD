package com.example.web10.users.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RequestUsersVo {

    @Schema(
            description = "사용자 이름",
            example = "chimeddorj",
            type = "string",
            maxLength = 50,
            nullable = false
    )
    @NotNull
    @Size(min=5, max=50)
    private String uname;

    @Schema(
            description = "나이",
            example = "24",
            type = "integer",
            nullable = true
    )
    @Min(1)
    private int age;

    @Schema(
            description = "phone 번호",
            example = "23982938923",
            type = "string",
            nullable=true
    )
    @Size(min = 8, max = 20)
    private String phone;
}
