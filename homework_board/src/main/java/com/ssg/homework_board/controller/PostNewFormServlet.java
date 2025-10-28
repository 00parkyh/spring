package com.ssg.homework_board.controller;

import com.ssg.homework_board.service.PostService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostNewFormServlet", urlPatterns = "/posts/new")
@Log4j2
public class PostNewFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "new"); // form.jsp가 '작성' 모드임을 알림
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/form.jsp");
        dispatcher.forward(req, resp);
    }

}
