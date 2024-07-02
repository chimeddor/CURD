package com.example.web10.project.service;

import com.example.web10.project.dao.ProjectDao;
import com.example.web10.project.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private final ProjectDao dao;

    @Override
    public void insert(RequestProjectVo vo) throws Exception {
        ProjectVo projectVo = ProjectVo
                .builder()
                .pname(vo.getPname())
                .proDesc(vo.getProDesc())
                .prStartDate(new Date())
                .prEndDate(vo.getPrEndDate())
                .crId(vo.getCrId())
                .build();

        dao.insert(projectVo);

    }
    @Override
    public int checkExist(RequestProjectListVo vo) throws Exception {
        return dao.checkExist(vo);
    }

    @Override
    public int checkId(RequestProjectUpdateVo vo) throws Exception {
        return dao.checkId(vo);
    }

    @Override
    public List<ProjectVo> search(RequestProjectListVo vo) throws Exception {
        return dao.search(vo);
    }

    @Override
    public void update(RequestProjectUpdateVo vo) throws Exception {
        ProjectVo projectVo = ProjectVo
                .builder()
                .pname(vo.getPname())
                .proDesc(vo.getProDesc())
                .pid(vo.getPid())
                .build();

        dao.update(projectVo);
    }

}
