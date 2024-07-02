package com.example.web10.users.controller;

import com.example.web10.project.vo.RequestProjectIdVo;
import com.example.web10.users.service.UsersService;
import com.example.web10.users.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.web10.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "users")
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/users", method = RequestMethod.POST)
public class UsersController {

    private final UsersService service;
//    @ApiResponse(responseCode = "400", description = "코드 추가 실패", content = @Content(schema = @Schema(implementation = ResponseVO.class))),

    @Operation(summary = "추가", description = "새로운 사용자 추가 부분")
    @RequestMapping("/insert")
    public @ResponseBody Response<?> insert(@Valid @RequestBody RequestUsersVo vo) throws Exception{
        service.insert(vo);
        return Response
                .builder()
                .message("OK")
                .data(new ArrayList<>())
                .status(HttpServletResponse.SC_OK).build();
    }

    @Operation(summary = "조회", description = "모든 사용자 조회")
    @RequestMapping("/search")
    public @ResponseBody Response<List<UsersVo>> searchList(@Valid @RequestBody RequestUsersListVo vo) throws Exception{

        int count = service.selectCount(vo);

        if (count == 0){
            return Response
                    .<List<UsersVo>>builder()
                    .data(new ArrayList<>())
                    .message("Not found")
                    .status(HttpServletResponse.SC_NOT_FOUND).build();
        }

        List<UsersVo> res = service.searchList(vo);
        return Response
                .<List<UsersVo>>builder()
                .data(res)
                .message("OK")
                .status(HttpServletResponse.SC_OK).build();
    }

    @Operation(summary = "수정", description = "사용자 수정")
    @RequestMapping("/update")
    public @ResponseBody Response<?> update(@Valid @RequestBody RequestUsersUpdateVo vo) throws Exception{

        service.update(vo);
        return Response
                .builder()
                .message("OK")
                .status(HttpServletResponse.SC_OK).build();
    }

    @Operation(summary = "삭제", description = "사용자 삭제")
    @RequestMapping("/delete")
    public @ResponseBody Response<?> delete(@Valid @RequestBody RequestUsersIdVo vo) throws Exception{
        int exist = service.checkExist(vo);

        if ( exist == 0){
            return Response
                    .builder()
                    .status(HttpServletResponse.SC_NOT_FOUND)
                    .message("Not found")
                    .build();
        }

        service.delete(vo);
        return Response
                .builder()
                .message("OK")
                .status(HttpServletResponse.SC_OK).build();
    }
}
