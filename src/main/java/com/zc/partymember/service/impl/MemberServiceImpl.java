package com.zc.partymember.service.impl;

import com.zc.partymember.domain.Member;
import com.zc.partymember.domain.User;
import com.zc.partymember.mapper.MemberMapper;
import com.zc.partymember.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Transactional
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> selectAll(String name,String area,String status,String start,String end,String meetingTime) {
        return memberMapper.selectAll(name,area,status,start,end,meetingTime);
    }

    @Override
    public int insert(Member member) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        member.setCreateBy(user.getId());
        member.setCreateDate(new Date());
        member.setUpdateBy(user.getId());
        member.setUpdateDate(new Date());
        return memberMapper.insert(member);
    }

    @Override
    public int updateByPrimaryKey(Member member) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        member.setUpdateBy(user.getId());
        member.setUpdateDate(new Date());
        return memberMapper.updateByPrimaryKey(member);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return memberMapper.deleteSelective(id);
    }

    @Override
    public Member findOne(int id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatusByPrimaryKey(Member member) {
        return memberMapper.updateStatusByPrimaryKey(member);
    }

}
