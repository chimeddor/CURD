package com.example.web10.users.vo;

import com.example.web10.project.vo.ProjectVo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class UsersVo {

        @Schema(
                description = "id",
                example = "1",
                type = "integer",
                nullable = false
        )
        private int idN;

        @Schema(
                description = "사용자 이름",
                example = "chimeddorj",
                type = "string",
                maxLength = 50,
                nullable = false
        )
        private String uname;

        @Schema(
                description = "나이",
                example = "24",
                type = "integer",
                nullable = true
        )
        private Integer age;

        @Schema(
                description = "phone 번호",
                example = "23982938923",
                type = "string",
                nullable=true
        )
        private String phone;

        @Schema(
                description = "update day",
                example = "2024-07-04T07:28:58.595Z",
                type = "date",
                nullable = false
        )
        private Date upDate;

        @Schema(
                description = "삭제 여부",
                example = "false",
                type = "boolean",
                nullable = false
        )
        private boolean delAltv;

//        @Schema(
//                description = "update 여부",
//                example = "1",
//                type = "int",
//                nullable = false
//        )
//        @NotNull
//        private int chngNm;

//        @Schema(
//                description = "project name",
//                example = "big data",
//                type = "string",
//                maxLength = 50,
//                nullable = false
//        )
//        @Size(min = 1, max = 50)
//        private String projectName;

}
