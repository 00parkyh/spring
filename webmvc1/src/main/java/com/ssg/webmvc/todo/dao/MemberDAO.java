package com.ssg.webmvc.todo.dao;

import com.ssg.webmvc.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDAO {
    public MemberVO getWithPassword(String mid, String pwd) throws Exception{
        String sql = "select * from member2 where mid=? and pwd=?";
        MemberVO vo = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,mid);
        preparedStatement.setString(2,pwd);

        @Cleanup ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        vo = MemberVO.builder().mid(rs.getString("mid")).pwd(rs.getString("pwd"))
                .mname(rs.getString("mname")).build();

        return vo;
    }
}
