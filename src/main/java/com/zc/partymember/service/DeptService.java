package com.zc.partymember.service;

import com.zc.partymember.domain.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> selectDeptsByFid(Integer fid);

    public Dept selectDeptById(Integer id);
}
