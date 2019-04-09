package com.zc.partymember.service.impl;

import com.zc.partymember.domain.User;
import com.zc.partymember.mapper.UserMapper;
import com.zc.partymember.service.ResetPwdService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResetPwdServiceImpl implements ResetPwdService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean resetpassword(String pwold, String pwnew,String username) throws Exception{
        User user = userMapper.selectByUsername(username);

        String md5 = "MD5";
        String _salt = ByteSource.Util.bytes(username).toString();
        Object salt = ByteSource.Util.bytes(_salt);
        int hasIter = 1024;

        Object result = new SimpleHash(md5, pwold, salt, hasIter);

//        _salt:存入到数据库中的盐值
        if(!user.getPassword().equals(result.toString())){
            throw new Exception("旧密码不正确");
        }else{
            Object resultnew = new SimpleHash(md5, pwnew, salt, hasIter);
            user.setPassword(resultnew.toString());
            user.setSalt(_salt);
            userMapper.updatePasswordByPrimaryKey(user);
            return true;
        }
    }
    @Transactional
    @Override
    public boolean initpwd() {
        String str = null;
        String md5 = "MD5";int hasIter = 1024;

//        List<User> userList =  userMapper.selectAll(str);
//        for(int i=0;i<userList.size();i++) {
//            User user = userList.get(i);
//            String _salt = ByteSource.Util.bytes(user.getUsername()).toString();
//            Object salt = ByteSource.Util.bytes(_salt);
//            Object result = new SimpleHash(md5, "123456", salt, hasIter);
//            user.setPassword(result.toString());
//            user.setSalt(_salt);
//            userMapper.updateByPrimaryKeySelective(user);
//        }

        return true;
    }
}
