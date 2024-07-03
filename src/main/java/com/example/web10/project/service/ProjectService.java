package com.example.web10.project.service;

import com.example.web10.project.vo.*;

import java.util.List;

public interface ProjectService {
    void insert(RequestProjectVo vo) throws Exception;
    List<ProjectVo> search(RequestProjectListVo vo) throws Exception;
    void update(RequestProjectUpdateVo vo) throws Exception;
    int checkExist(RequestProjectListVo vo) throws Exception;
    int checkId(RequestProjectUpdateVo vo) throws Exception;
    int checkUid(RequestProjectVo vo) throws Exception;
}
