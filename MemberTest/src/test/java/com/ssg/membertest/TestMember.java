package com.ssg.membertest;


import com.ssg.membertest.Repository.MemberDAO;
import com.ssg.membertest.Service.MemberService;
import com.ssg.membertest.VO.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class TestMember {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void testinsertMember() throws Exception {
        MemberVO list = new MemberVO();

        list.setMid("member04");
        list.setPwd("5555");
        list.setMname("리트리버");

        memberDAO.insertMember(list);
    }

    @Test
    public void selectAllTest() throws Exception {

        List<MemberVO> memberVOList = memberDAO.selectAllMember();
        log.info("조회된 회원 수: " + memberVOList.size());

        for(MemberVO member : memberVOList) {
            log.info(member.toString());
        }
    }
}
