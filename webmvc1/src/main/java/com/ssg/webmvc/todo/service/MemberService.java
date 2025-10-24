package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.MemberDAO;
import com.ssg.webmvc.todo.domain.MemberVO;
import com.ssg.webmvc.todo.dto.MemberDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        this.dao = new MemberDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String pwd) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, pwd);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        return dto;

    }
}
