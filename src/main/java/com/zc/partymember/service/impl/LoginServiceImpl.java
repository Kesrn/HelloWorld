package com.zc.partymember.service.impl;

import com.zc.partymember.domain.User;
import com.zc.partymember.mapper.UserMapper;
import com.zc.partymember.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly=true)
    @Override
    public User selectByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        return user;
    }
}
