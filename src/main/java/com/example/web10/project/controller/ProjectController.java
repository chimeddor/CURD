package com.example.web10.project.controller;

import com.example.web10.project.service.ProjectService;
import com.example.web10.project.vo.*;
import com.example.web10.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Tag(name = "project")
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/project", method = RequestMethod.POST)
public class ProjectController {

    @Autowired
    private final ProjectService service;

    @Operation(summary = "추가", description = "사용자의 프로젝트 추가")
    @RequestMapping("/insert")
    public @ResponseBody Response<?> insert(@Valid @RequestBody RequestProjectVo vo) throws Exception{
        service.insert(vo);
        return Response
                .builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .build();
    }

    @Operation(summary = "조회", description = "프로젝트 조회",
            responses = {@ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(schema = @Schema(implementation = Response.class)))})
    @RequestMapping("/search")
    public @ResponseBody Response<List<ProjectVo>> search(@Valid @RequestBody RequestProjectListVo vo) throws Exception{

        int count = service.checkExist(vo);
        if (count == 0){
            return Response
                    .<List<ProjectVo>>builder()
                    .status(HttpServletResponse.SC_NOT_FOUND)
                    .message("Not Found")
                    .build();
        }

        List<ProjectVo> rsp = service.search(vo);

        return Response
                .<List<ProjectVo>>builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .data(rsp)
                .build();
    }

    @Operation(summary = "수정", description = "프로젝트 수정")
    @RequestMapping("/update")
    public @ResponseBody Response<?> update(@Valid @RequestBody RequestProjectUpdateVo vo) throws Exception{
       int exist = service.checkId(vo);

       if (exist == 0){
           return Response
                   .builder()
                   .status(HttpServletResponse.SC_NOT_FOUND)
                   .message("Not Found")
                   .build();
       }

        service.update(vo);

        return Response
                .builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .build();
    }

}
