package com.zc.partymember.service;

public interface ResetPwdService {
    boolean resetpassword(String pwold, String pwnew,String username) throws Exception;
    boolean initpwd() throws Exception;
}
