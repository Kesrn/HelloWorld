package com.zc.partymember.service;

import com.zc.partymember.domain.Member;

import java.util.List;

public interface MemberService {
    List<Member> selectAll(String name,String area,String status,String start,String end,String meetingTime);

    int insert(Member member);

    int updateByPrimaryKey(Member member);

    int deleteByPrimaryKey(int id);

    Member findOne(int id);

    int updateStatusByPrimaryKey(Member member);
}
