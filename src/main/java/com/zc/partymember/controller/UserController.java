package com.zc.partymember.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.partymember.common.ApiConst;
import com.zc.partymember.common.Consts;
import com.zc.partymember.common.ResultBody;
import com.zc.partymember.domain.Dept;
import com.zc.partymember.domain.User;
import com.zc.partymember.service.DeptService;
import com.zc.partymember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(ApiConst.API_USER)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;

    @RequestMapping()
    public String list() {
        return "user/list";
    }
    @ResponseBody
    @RequestMapping(ApiConst.API_USER_LIST)
    public ResultBody onList(@RequestParam(name = "page")Integer currPage,
                             @RequestParam("limit")Integer pageSize) {
        ResultBody resultBody = new ResultBody();

        PageHelper.startPage(currPage, pageSize);
        try {
            List<User> userList = userService.findAll();
            for(User user : userList){
                if(user.getSex().equals("0")){
                    user.setSex("男");
                }else {
                    user.setSex("女");
                }
            }
            PageInfo<User> userPageInfo = new PageInfo<>(userList);
            resultBody.setCode(Consts.SUCCESS);
            resultBody.setMsg("");
            resultBody.setData(userList);
            resultBody.setCount(Long.valueOf(userPageInfo.getTotal()));
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultBody;

    }

    @GetMapping(ApiConst.API_USER_CREATE)
    public String showCreateForm(Model model) {
        List<Dept> depts = deptService.selectDeptsByFid(1);
        model.addAttribute("depts",depts);
        return "user/create";
    }

    @PostMapping(ApiConst.API_USER_CREATE)
    @ResponseBody
    public ResultBody create(User user, RedirectAttributes redirectAttributes) {
        ResultBody resultBody = new ResultBody();
        if(user.getUsername().trim().equals("")){
             return resultBody.failure("用户名不能为空！");
        }
        if(user.getRole().equals("County") && user.getDeptId() == null){
            return resultBody.failure("所属区县不能为空！");
        }
        User user1 = userService.findByUsername(user.getUsername().trim());
        if(user1 != null){
            return resultBody.failure("当前用户名已存在！");
        }
        userService.createUser(user);
        return resultBody.success(new ArrayList<>(),"用户创建成功！");
    }

    @GetMapping(ApiConst.API_USER_UPDATE)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        List<Dept> depts = deptService.selectDeptsByFid(1);
        model.addAttribute("depts",depts);
        return "user/edit";
    }

    @PostMapping(ApiConst.API_USER_UPDATE)
    @ResponseBody
    public ResultBody update(User user, RedirectAttributes redirectAttributes) {
        ResultBody resultBody = new ResultBody();
        if(user.getUsername().trim().equals("")){
            return resultBody.failure("用户名不能为空！");
        }
        if(user.getRole().equals("County") && user.getDeptId() == null){
            return resultBody.failure("所属区县不能为空！");
        }
        User user1 = userService.findByUsername(user.getUsername().trim());
        if(user1 != null && user1.getId() != user.getId()){
            return resultBody.failure("当前用户名已存在！");
        }
        userService.updateUser(user);
        return resultBody.success(new ArrayList<>(),"用户编辑成功！");
    }


    @PostMapping(ApiConst.API_USER_DELETE)
    @ResponseBody
    public ResultBody delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ResultBody resultBody = new ResultBody();
        userService.deleteUser(id);
        return resultBody.success(new ArrayList<>(),"用户删除成功！");
    }


}
