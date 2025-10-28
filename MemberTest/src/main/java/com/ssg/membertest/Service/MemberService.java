package com.ssg.membertest.Service;

import com.ssg.membertest.DTO.Member;
import com.ssg.membertest.VO.MemberVO;

import java.util.List;

public interface MemberService {
    void joingMember(MemberVO member);
    List<MemberVO> memberList();
}
