package com.example.web10.users.service;

import com.example.web10.users.vo.*;

import java.util.List;

public interface UsersService {
    void insert(RequestUsersVo vo) throws Exception;
    List<UsersVo> searchList(RequestUsersListVo vo) throws Exception;
    int selectCount(RequestUsersListVo vo) throws Exception;
    void update(RequestUsersUpdateVo vo) throws Exception;
    void delete(RequestUsersIdVo vo) throws Exception;
    int checkExist(RequestUsersIdVo vo) throws Exception;
}