package com.zc.partymember.mapper;

import com.zc.partymember.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    public User selectByUsername(String username);

    List<User> selectAll();

    public User selectByPrimaryKey(int id);

    public int updateByPrimaryKey(User user);

    public int deleteByPrimaryKey(int id);

    public int updatePasswordByPrimaryKey(User user);
}