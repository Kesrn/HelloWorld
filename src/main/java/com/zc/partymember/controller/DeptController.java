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
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @ResponseBody
    @RequestMapping("/selectDeptsByFid")
    public ResultBody selectDeptsByFid(@RequestParam("fid") Integer fid) {
        ResultBody resultBody = new ResultBody();
        List<Dept> depts = deptService.selectDeptsByFid(fid);
        return resultBody.success(depts,"获取数据成功");

    }
}
