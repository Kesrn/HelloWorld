package com.zc.partymember.service;

import com.zc.partymember.domain.User;

import java.util.List;

public interface UserService {
    int createUser(User user);

    int updateUser(User user);

    void deleteUser(int id);

    User findOne(int id);

    List<User> findAll();

    User findByUsername(String username);

}
