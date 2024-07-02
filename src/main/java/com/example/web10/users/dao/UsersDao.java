package com.example.web10.users.dao;

import com.example.web10.users.vo.RequestUsersIdVo;
import com.example.web10.users.vo.RequestUsersListVo;
import com.example.web10.users.vo.UsersVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UsersDao {
    int insert(UsersVo vo) throws Exception;
    List<UsersVo> searchList(RequestUsersListVo vo) throws Exception;
    int selectCount(RequestUsersListVo vo) throws Exception;
    int update(UsersVo vo) throws Exception;
    int delete(UsersVo vo) throws Exception;
    int checkExist(RequestUsersIdVo vo) throws Exception;
}
