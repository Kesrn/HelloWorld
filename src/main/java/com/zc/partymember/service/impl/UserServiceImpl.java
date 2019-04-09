package com.zc.partymember.service.impl;

import com.zc.partymember.domain.User;
import com.zc.partymember.mapper.UserMapper;
import com.zc.partymember.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int createUser(User user) {
        String md5 = "MD5";
        String _salt = ByteSource.Util.bytes(user.getUsername()).toString();
        Object salt = ByteSource.Util.bytes(_salt);
        int hasIter = 1024;

        Object result = new SimpleHash(md5, "123456", salt, hasIter);
        user.setPassword(result.toString());
        user.setStatus("0");
        user.setSalt(_salt);
        if(user.getRole().equals("Municipal")){
            user.setDeptId(1);
        }
        User user1 = (User) SecurityUtils.getSubject().getPrincipal();
        user.setCreateBy(user1.getId());
        user.setCreateDate(new Date());
        user.setUpdateBy(user1.getId());
        user.setUpdateDate(new Date());
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        if(user.getRole().equals("Municipal")){
            user.setDeptId(1);
        }
        User user1 = (User) SecurityUtils.getSubject().getPrincipal();
        user.setUpdateBy(user1.getId());
        user.setUpdateDate(new Date());
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }


    @Override
    public User findOne(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }



    @Override
    public User findByUsername(String username) {
        return userMapper.selectByUsername(username);
    }


}
