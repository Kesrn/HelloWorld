package com.zc.partymember.mapper;

import com.zc.partymember.domain.Dept;

import java.util.List;

public interface DeptMapper {

    public List<Dept> selectDeptsByFid(Integer fid);

    public Dept selectDeptById(Integer id);
}
