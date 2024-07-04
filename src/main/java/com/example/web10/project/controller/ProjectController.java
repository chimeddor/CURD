package com.example.web10.project.controller;

import com.example.web10.project.service.ProjectService;
import com.example.web10.project.vo.*;
import com.example.web10.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "project")
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/project", method = RequestMethod.POST)
public class ProjectController {

    @Operation(summary = "추가", description = "사용자의 프로젝트 추가",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Response.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ValidErrorResponse.class)))})
    @RequestMapping("/insert")
    public @ResponseBody Response<?> insert(@Valid @RequestBody RequestProjectVo vo) throws Exception{

        // 해당 유저가 존재하는지 확인.
        int exist = service.checkUid(vo);

        if (exist == 0){
           throw new NotFoundException("Not Found", HttpStatus.NOT_FOUND.value());
        }

        service.insert(vo);
        return Response
                .builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .build();
    }

    @Autowired
    private final ProjectService service;

    @Operation(summary = "조회", description = "프로젝트 조회",
            responses = {
                        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Response.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ValidErrorResponse.class))),
                        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResult.class)))
            })
    @RequestMapping("/search")
    public @ResponseBody Response<List<ProjectVo>> search(@Valid @RequestBody RequestProjectListVo vo) throws Exception{

        int check = service.checkExist(vo);
        if (check == 0){
            throw new NotFoundException("Not Found", HttpStatus.NOT_FOUND.value());
        }

        List<ProjectVo> rsp = service.search(vo);

        return Response
                .<List<ProjectVo>>builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .data(rsp)
                .build();
    }

    @Operation(summary = "수정", description = "프로젝트 수정",
            responses = {
                        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Response.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ValidErrorResponse.class))),
                        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResult.class)))
    })
    @RequestMapping("/update")
    public @ResponseBody Response<?> update(@Valid @RequestBody RequestProjectUpdateVo vo) throws Exception{
        int check = service.checkId(vo);
        if (check == 0){
            throw new NotFoundException("Not Found", HttpStatus.NOT_FOUND.value());
        }

        service.update(vo);
        return Response
                .builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .build();
    }

}
