package com.zc.partymember.service.impl;

import com.zc.partymember.domain.Dept;
import com.zc.partymember.mapper.DeptMapper;
import com.zc.partymember.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selectDeptsByFid(Integer fid) {
        return deptMapper.selectDeptsByFid(fid);
    }

    @Override
    public Dept selectDeptById(Integer id) {
        return deptMapper.selectDeptById(id);
    }

}
