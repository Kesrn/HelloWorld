package com.zc.partymember.controller;

import com.zc.partymember.common.ResultBody;
import com.zc.partymember.domain.User;
import com.zc.partymember.service.ResetPwdService;
import com.zc.partymember.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ResetPwdController {

    @Autowired
    private ResetPwdService resetPwdService;

    @Autowired
    private UserService userService;

    @GetMapping("/resetPwd")
    public String toalter() {
        return "resetPwd/index";
    }

    @PostMapping("/resetPwdok")
    @ResponseBody
    public ResultBody doalter(@RequestParam String pwold,@RequestParam String pwnew,Model model){
        ResultBody resultBody = new ResultBody();
        try {
            Subject subject = SecurityUtils.getSubject();
            User user = (User)subject.getPrincipal();
            boolean ret = resetPwdService.resetpassword(pwold,pwnew,user.getUsername());
            if(ret){
                return resultBody.success(new ArrayList<>(),"密码修改成功");
            }
        }catch (Exception ex) {
            return resultBody.failure("密码修改失败");
        }
        //return "resetPwd/ok";
        return resultBody.failure("密码修改失败");
    }
    @GetMapping("/userInfo")
    public String userInfo(Model model){

        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        model.addAttribute("user",userService.findOne(user.getId()));
        return "home/info";
    }

    @GetMapping("/initpwd")
    @ResponseBody
    public String doalter(){
        try {

            boolean ret = resetPwdService.initpwd();
            if(ret){
                return "密码修改成功";
            }
        }catch (Exception ex) {
            return ex.getMessage();
        }
        //return "resetPwd/ok";
        return "密码修改失败";
    }

}
