/**
 * All rights Reserved, Designed By ZC.LangFang
 * @Title:  LoginController.java
 * @author: XueYang.Li
 * @date:   2019/3/1 9:31 AM
 * @version V1.0
 * @Copyright: 2019/3/1 INM Inc. All rights reserved.
 * 注意：本内容仅限于河北志晟信息技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.zc.partymember.controller;

import com.zc.partymember.common.ApiConst;
import com.zc.partymember.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @Title: LoginController
* @Package: com.zc.partymember.controller
* @Describe: 登录
* @author: XueYang.Li
* @date: 2019/3/1 9:32 AM
* @version: V1.0
**/
@Controller
public class LoginController {

    @GetMapping(ApiConst.API_LOGIN)
    public String toLogin() {
        return "login/login";
    }

    @PostMapping(ApiConst.API_LOGIN)
    public String onLogin(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {

        try {
            Subject subject = SecurityUtils.getSubject();
            if (!subject.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken();
                token.setUsername(username);
                token.setPassword(password.toCharArray());

                subject.login(token);
            }
            model.addAttribute("user", (User)subject.getPrincipal());

            return "index";
        }catch (UnknownAccountException ex) {
            ex.printStackTrace();
            model.addAttribute("errMsg", "用户或密码错误");
        }catch (IncorrectCredentialsException ex) {
            ex.printStackTrace();
            model.addAttribute("errMsg", "用户或密码错误");
        }catch (LockedAccountException ex) {
            ex.printStackTrace();
            model.addAttribute("errMsg", "用户已被锁定，请联系管理员处理");
        }catch (AuthenticationException ex) {
            ex.printStackTrace();
            model.addAttribute("errMsg", "系统繁忙，请稍后再试");
        }

        return "login/login";
    }

    @GetMapping(ApiConst.API_HOME_CONSOLE)
    public String onHome() {

        return "home/console";
    }

    @GetMapping(ApiConst.API_LOGOUT)
    public String onLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "login/login";
    }
}
