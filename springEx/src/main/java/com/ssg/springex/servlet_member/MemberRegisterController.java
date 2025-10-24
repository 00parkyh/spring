package com.ssg.springex.servlet_member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemberRegisterController" , urlPatterns = "/member/register")
public class MemberRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("gender");

        String[] hobbyArray = req.getParameterValues("hobby");
        String hobby = "";
        if(hobbyArray != null && hobbyArray.length > 0) {
            hobby = String.join(",", hobbyArray);
        } // 필수 입렷 사항이 아닌 항목 null 처리

        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPwd(pwd);
        vo.setSex(sex);
        vo.setHobby(hobby);

        MemberDAO dao = new MemberDAO();
        boolean result = dao.addMember(vo);

        String message = "";
        if(result) {
             message = id +"님 회원 가입 성공했습니다.";
        } else {
            message = " 다시 시도 하십시오";
        }

        req.setAttribute("message", message);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/servlet_member/result.jsp");
        dispatcher.forward(req, resp);
    }
}