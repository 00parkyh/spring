package com.ssg.membertest.Service;

import com.ssg.membertest.DTO.MemberDTO;
import com.ssg.membertest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl2 implements MemberService2 {

    private final MemberMapper memberMapper;

    @Override
    public void registerMember(MemberDTO member) {
        memberMapper.registerMember(member);
    }

    @Override
    public List<MemberDTO> memberList() {
        return memberMapper.memberList();
    }
}
