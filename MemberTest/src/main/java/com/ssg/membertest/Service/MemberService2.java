package com.ssg.membertest.Service;

import com.ssg.membertest.DTO.MemberDTO;

import java.util.List;

public interface MemberService2 {
    void registerMember(MemberDTO member);
    List<MemberDTO> memberList();

}
