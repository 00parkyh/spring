package com.ssg.membertest.Service;

import com.ssg.membertest.DTO.Member;
import com.ssg.membertest.Repository.MemberDAO;
import com.ssg.membertest.VO.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@ToString
public class MemberServiceImpl implements MemberService {

    private final MemberDAO dao;

    @Override
    @Transactional
    public void joingMember(MemberVO member) {
        dao.insert(member);
    }

    @Override
    @Transactional
    public List<MemberVO> memberList() {
        return dao.findAll();
    }
}
