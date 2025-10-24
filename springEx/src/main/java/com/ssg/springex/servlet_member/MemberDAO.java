package com.ssg.springex.servlet_member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Statement stmt;
    private Connection conn;
    private PreparedStatement pstmt;

    private void ConnDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul","root","mysql1234");
            System.out.println("Connection 생성 성공");
            stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");
        }catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addMember(MemberVO vo) {
        boolean result = false;
        try {
            ConnDB();
            String sql = "INSERT INTO memberinfo (id, pwd, sex, hobby) VALUES (?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPwd());
            pstmt.setString(3, vo.getSex());
            pstmt.setString(4, vo.getHobby());

            int count = pstmt.executeUpdate();
            if (count > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
