package com.zc.partymember.service;

import com.zc.partymember.domain.User;

public interface ILoginService {
    User selectByUsername(String username);
}
