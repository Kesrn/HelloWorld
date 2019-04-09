package com.zc.partymember.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.partymember.common.ApiConst;
import com.zc.partymember.common.Consts;
import com.zc.partymember.common.ResultBody;
import com.zc.partymember.domain.Dept;
import com.zc.partymember.domain.Member;
import com.zc.partymember.domain.User;
import com.zc.partymember.service.DeptService;
import com.zc.partymember.service.MemberService;
import com.zc.partymember.service.UserService;
import com.zc.partymember.utils.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(ApiConst.API_MEMBER)
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserService userService;

    @GetMapping()
    public String list(Model model) {
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("user", (User) subject.getPrincipal());
        return "member/list";
    }

    @GetMapping(ApiConst.API_MEMBER_CREATE)
    public String add(Model model) {
        List<Dept> depts = deptService.selectDeptsByFid(1);
        model.addAttribute("depts", depts);
        List<Dept> depts1 = deptService.selectDeptsByFid(2);
        model.addAttribute("depts1", depts1);
        List<Dept> depts2 = deptService.selectDeptsByFid(13);
        model.addAttribute("depts2", depts2);
        return "member/create";
    }

    @GetMapping(ApiConst.API_MEMBER_UPDATE)
    public String update(@PathVariable("id") Integer id, Model model) {
        Member member = memberService.findOne(id);
        model.addAttribute("member", member);
        Dept dept = deptService.selectDeptById(member.getArea());
        List<Dept> depts = deptService.selectDeptsByFid(dept.getFid());
        model.addAttribute("dept_1", dept);
        model.addAttribute("depts", depts);
        Dept dept1 = deptService.selectDeptById(member.getTownship());
        List<Dept> depts1 = deptService.selectDeptsByFid(dept1.getFid());
        model.addAttribute("dept_2", dept1);
        model.addAttribute("depts1", depts1);
        Dept dept2 = deptService.selectDeptById(member.getVillageStreet());
        List<Dept> depts2 = deptService.selectDeptsByFid(dept2.getFid());
        model.addAttribute("dept_3", dept2);
        model.addAttribute("depts2", depts2);

        String path = member.getPicPath();
        String[] split = path.split("\\|");
        model.addAttribute("path1", split[0]);
        model.addAttribute("path2", split[1]);
        model.addAttribute("path3", split[2]);
        return "member/edit";
    }

    @GetMapping(ApiConst.API_MEMBER_LIST)
    @ResponseBody
    public ResultBody onList(@RequestParam(name = "page") Integer currPage,
                             @RequestParam("limit") Integer pageSize,
                             @RequestParam(name = "name", required = false) String name,
                             @RequestParam(name = "area", required = false) String area,
                             @RequestParam(name = "status", required = false) String status,
                             @RequestParam(name = "start", required = false) String start,
                             @RequestParam(name = "end", required = false) String end,
                             @RequestParam(name = "meetingTime", required = false) String meetingTime
    ) {
        ResultBody resultBody = new ResultBody();
        try {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();
            String str = userService.findByUsername(user.getUsername()).getDeptId().toString();
            String skr = userService.findByUsername(user.getUsername()).getRole();
            if (!skr.equals("Municipal")) {
                area = str;
                PageHelper.startPage(currPage, pageSize);
                List<Member> memberList = memberService.selectAll(name, area, status, start, end, meetingTime);
                PageInfo<Member> pageInfo = new PageInfo<>(memberList);
            }
            PageHelper.startPage(currPage, pageSize);
            List<Member> memberList = memberService.selectAll(name, area, status, start, end, meetingTime);
            PageInfo<Member> pageInfo = new PageInfo<>(memberList);

            resultBody.setCode(Consts.SUCCESS);
            resultBody.setMsg("查询成功");
            resultBody.setData(memberList);
            resultBody.setCount(Long.valueOf(pageInfo.getTotal()));
        } catch (Exception ex) {
            ex.printStackTrace();
            resultBody = resultBody.failure("系统繁忙，请稍后再试！");
        }
        return resultBody;

    }

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @PostMapping(ApiConst.API_MEMBER_CREATE)
    @ResponseBody
    public ResultBody onCreate(Member member, HttpServletRequest request) {
        ResultBody resultBody = new ResultBody();
        try {
            String path1 = request.getParameter("path1");
            String path2 = request.getParameter("path2");
            String path3 = request.getParameter("path3");
            String path = path1 + "|" + path2 + "|" + path3;
            member.setPicPath(path);
            memberService.insert(member);
            resultBody = resultBody.success(new ArrayList<>(), "用户创建成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            resultBody = resultBody.failure("系统繁忙，请稍后再试！");
        }
        return resultBody;
    }


    @PutMapping(ApiConst.API_MEMBER_UPDATE)
    @ResponseBody
    public ResultBody onUpdate(Member member, HttpServletRequest request) {

        ResultBody resultBody = new ResultBody();
        try {
            String path1 = request.getParameter("path1");
            String path2 = request.getParameter("path2");
            String path3 = request.getParameter("path3");
            String path = path1 + "|" + path2 + "|" + path3;
            member.setPicPath(path);
            memberService.updateByPrimaryKey(member);
            resultBody = resultBody.success(new ArrayList<>(), "用户修改成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            resultBody = resultBody.failure("系统繁忙，请稍后再试！");
        }

        return resultBody;
    }

    @DeleteMapping(ApiConst.API_MEMBER_DELETE)
    @ResponseBody
    public ResultBody onDelete(@PathVariable("id") Integer id) {
        ResultBody resultBody = new ResultBody();
        try {
            memberService.deleteByPrimaryKey(id);
            resultBody = resultBody.success(new ArrayList<>(), "用户删除成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            resultBody = resultBody.failure("系统繁忙，请稍后再试！");
        }


        return resultBody;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ResultBody onUpload(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest request) {
        ResultBody resultBody = new ResultBody();
        String suffix = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
        String savePath = "userfiles/pic/" + DateUtils.getYear() + "/" + DateUtils.getMonth() + "/";
        String path = "D:/profile/" + savePath;
        String saveName = (int) ((Math.random() * 9 + 1) * 100000) + suffix;
        //新文件存储路径
        File targetFile = new File(path);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //保存
        try {
            uploadFile.transferTo(new File(path + saveName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("filepath", savePath + saveName);
        return resultBody.success(map, "上传成功");
    }

    @GetMapping("/{id}/audit")
    public String audit(@PathVariable("id") Integer id, Model model) {
        Member member = memberService.findOne(id);
        model.addAttribute("member", member);
        Dept dept = deptService.selectDeptById(member.getArea());
        List<Dept> depts = deptService.selectDeptsByFid(dept.getFid());
        model.addAttribute("dept_1", dept);
        model.addAttribute("depts", depts);
        Dept dept1 = deptService.selectDeptById(member.getTownship());
        List<Dept> depts1 = deptService.selectDeptsByFid(dept1.getFid());
        model.addAttribute("dept_2", dept1);
        model.addAttribute("depts1", depts1);
        Dept dept2 = deptService.selectDeptById(member.getVillageStreet());
        List<Dept> depts2 = deptService.selectDeptsByFid(dept2.getFid());
        model.addAttribute("dept_3", dept2);
        model.addAttribute("depts2", depts2);

        String path = member.getPicPath();
        String[] split = path.split("\\|");
        model.addAttribute("path1", split[0]);
        model.addAttribute("path2", split[1]);
        model.addAttribute("path3", split[2]);
        return "member/audit";
    }

    @PostMapping("/{id}/audit")
    @ResponseBody
    public ResultBody onAudit(Member member, HttpServletRequest request) {
        ResultBody resultBody = new ResultBody();
        try {
            String flag = request.getParameter("flag");
            if (flag.equals("yes")) {
                member.setStatus("2");
                member.setNo_agree_reason("");
            } else {
                member.setStatus("1");
                member.setNo_agree_reason(request.getParameter("reason"));
            }
            memberService.updateStatusByPrimaryKey(member);
            resultBody = resultBody.success(new ArrayList<>(), "用户修改成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            resultBody = resultBody.failure("系统繁忙，请稍后再试！");
        }

        return resultBody;
    }
}
