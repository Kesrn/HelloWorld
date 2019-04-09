package com.zc.partymember.mapper;

import com.zc.partymember.domain.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    int insert(Member record);

    List<Member> selectAll(@Param("name")String name
    ,@Param("area")String area,@Param("status")String status,@Param("start")String start
            ,@Param("end")String end,@Param("meetingTime")String meetingTime);

    int updateByPrimaryKey(Member member);

    int deleteSelective(int id);

    Member selectByPrimaryKey(int id);

    int updateStatusByPrimaryKey(Member member);
}