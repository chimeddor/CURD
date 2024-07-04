package com.example.web10.users.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class RequestUsersIdVo {
    @Schema(
            description = "id",
            example = "1",
            type = "integer",
            nullable = false
    )
    @NotNull
    @Min(1)
    private int idN;
}
