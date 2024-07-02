package com.example.web10.users.service;

import com.example.web10.response.ErrorCode;
import com.example.web10.response.ErrorResult;
import com.example.web10.response.NotFoundException;
import com.example.web10.users.dao.UsersDao;
import com.example.web10.users.vo.*;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UsersServiceImpl implements UsersService{

    @Autowired
    private final UsersDao dao;

    @Override
    public void insert(RequestUsersVo vo) throws Exception {
        UsersVo usersVo = UsersVo
                .builder()
                .uname(vo.getUname())
                .age(vo.getAge())
                .phone(vo.getPhone())
                .upDate(new Date())
                .build();
        dao.insert(usersVo);
    }

    @Override
    public List<UsersVo> searchList(RequestUsersListVo vo) throws Exception {
        return dao.searchList(vo);
    }

    @Override
    public int selectCount(RequestUsersListVo vo) throws Exception {
        return dao.selectCount(vo);
    }

    @Override
    public void update(RequestUsersUpdateVo vo) throws Exception {

        UsersVo usersVo = UsersVo
                .builder()
                .idN(vo.getIdN())
                .uname(vo.getUname())
                .phone(vo.getPhone())
                .age(vo.getAge())
                .upDate(new Date())
                .build();

            if (dao.update(usersVo) == 0){
                throw new NotFoundException("Not Found", HttpStatus.NOT_FOUND.value());
            }
    }

    @Override
    public int checkExist(RequestUsersIdVo vo) throws Exception {
        return dao.checkExist(vo);
    }

    @Override
    public void delete(RequestUsersIdVo vo) throws Exception {

        UsersVo usersVo = UsersVo
                .builder()
                .idN(vo.getIdN())
                .upDate(new Date())
                .build();

        dao.delete(usersVo);
    }

}
