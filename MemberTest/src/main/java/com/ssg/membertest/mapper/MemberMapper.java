package com.ssg.membertest.mapper;

import com.ssg.membertest.DTO.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void registerMember(MemberDTO member);
    List<MemberDTO> memberList();
}
