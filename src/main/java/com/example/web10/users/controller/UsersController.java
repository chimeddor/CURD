package com.example.web10.users.controller;

import com.example.web10.project.vo.RequestProjectIdVo;
import com.example.web10.response.*;
import com.example.web10.response.handler.GlobalExceptionHandler;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // reponseCode은 swagge에서 Code 부분
    // description은 swagge에서 바로 보이는 description 부분
    // swagge에서 바로 보이는 implementation에 있는 class가 있어야 처리 status과 메시지가 제대로 보인다. 부분

    @Operation(summary = "추가", description = "새로운 사용자 추가 부분",
            responses = {@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Response.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ValidErrorResponse.class)))
    })
    @RequestMapping("/insert")
    public @ResponseBody Response<?> insert(@Valid @RequestBody RequestUsersVo vo) throws Exception{
        service.insert(vo);
        return Response
                .builder()
                .message("OK")
                .data(new ArrayList<>())
                .status(HttpServletResponse.SC_OK).build();
    }

    @Operation(summary = "조회", description = "모든 사용자 조회",
            responses = {
                        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Response.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ValidErrorResponse.class))),
                        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResult.class)))
    })
    @RequestMapping("/search")
    public @ResponseBody Response<List<UsersVo>> searchList(@Valid @RequestBody RequestUsersListVo vo) throws Exception{

        int count = service.selectCount(vo);
        if (count == 0){
            throw new NotFoundException("Not Found", HttpStatus.NOT_FOUND.value());
        }

//        int count = service.selectCount(vo);
//
//        if (count == 0){
//            return Response
//                    .<List<UsersVo>>builder()
//                    .data(new ArrayList<>())
//                    .message("Not found")
//                    .status(HttpServletResponse.SC_NOT_FOUND).build();
//        }

        List<UsersVo> res = service.searchList(vo);
        return Response
                .<List<UsersVo>>builder()
                .data(res)
                .message("OK")
                .status(HttpServletResponse.SC_OK).build();
    }

    @Operation(summary = "수정", description = "사용자 수정",
            responses = {
                        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Response.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ValidErrorResponse.class))),
                        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResult.class)))
    })
    @RequestMapping("/update")
    public @ResponseBody Response<?> update(@Valid @RequestBody RequestUsersUpdateVo vo) throws Exception{

        service.update(vo);
        return Response
                .builder()
                .message("OK")
                .status(HttpServletResponse.SC_OK).build();
    }

    @Operation(summary = "삭제", description = "사용자 삭제",
            responses = {
                        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Response.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ValidErrorResponse.class))),
                        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResult.class)))
            })
    @RequestMapping("/delete")
    public @ResponseBody Response<?> delete(@Valid @RequestBody RequestUsersIdVo vo) throws Exception{
//        int exist = service.checkExist(vo);
//
//        if ( exist == 0){
//            return Response
//                    .builder()
//                    .status(HttpServletResponse.SC_NOT_FOUND)
//                    .message("Not found")
//                    .build();
//        }

        int count = service.checkExist(vo);

        if (count == 0){
            throw new NotFoundException("Not Found", HttpStatus.NOT_FOUND.value());
        }

        service.delete(vo);
        return Response
                .builder()
                .message("OK")
                .status(HttpServletResponse.SC_OK).build();
    }
}
