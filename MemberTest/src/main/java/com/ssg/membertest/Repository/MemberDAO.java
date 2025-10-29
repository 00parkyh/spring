package com.ssg.membertest.Repository;

import com.ssg.membertest.DTO.MemberDTO;
import com.ssg.membertest.VO.MemberVO;
import java.util.List;

public interface MemberDAO {
    public void insertMember(MemberVO vo) throws Exception;
    public List<MemberVO> selectAllMember() throws Exception;

    int insert(MemberVO member);
    List<MemberVO> findAll();
}
