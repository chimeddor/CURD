package com.example.web10.project.dao;

import com.example.web10.project.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProjectDao {
    int insert(ProjectVo vo) throws Exception;
    List<ProjectVo> search(RequestProjectListVo vo) throws Exception;
    int update(ProjectVo vo) throws Exception;
    int checkExist(RequestProjectListVo vo) throws Exception;
    int checkId(RequestProjectUpdateVo vo) throws Exception;
    int checkUid(RequestProjectVo vo) throws Exception;
}
