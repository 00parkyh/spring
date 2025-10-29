package com.ssg.membertest.member.service;

import com.ssg.membertest.DTO.MemberDTO;
import com.ssg.membertest.Service.MemberService;
import com.ssg.membertest.VO.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    @Rollback(false)
    public void joinMember() {
        MemberVO member = new MemberVO();
        member.setMid("member06");
        member.setPwd("7777");
        member.setMname("박길동");

        memberService.joingMember(member);
    }

    @Test
    public void memberList() {
        memberService.memberList().forEach(System.out::println);
    }
}
