package com.ssg.springex.servlet_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();    //SQL문으로 조회할 memberDAO 객체를 생성
        List<MemberVO> memberList = dao.listMembers();  // listMembers()를 통해서 회원정보를 조회우 결과인 회원정보리스트를 전달받는다.

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<table border=1><tr align='center' bgcolor='lightgreen'> >");
        out.println("<th>아이디</th><th>이름</th><th>이메일</th><th>가입일</th></tr>");
        for (int i= 0; i<memberList.size(); i++){
            String id=memberList.get(i).getId();
            String name=memberList.get(i).getName();
            String email=memberList.get(i).getEmail();
            Date joinDate=memberList.get(i).getJoinDate();

            out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td></tr>");
        }
        out.println("</table></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
