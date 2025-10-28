package com.ssg.homework_board.controller;

import com.ssg.homework_board.dto.PostDTO;
import com.ssg.homework_board.service.PostService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostSaveServlet", urlPatterns = "/posts/save")
@Log4j2
public class PostSaveServlet extends HttpServlet {
    private PostService service = PostService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        PostDTO dto = PostDTO.builder()
                .title(req.getParameter("title"))
                .content(req.getParameter("content"))
                .writer(req.getParameter("writer"))
                .passphrase(req.getParameter("passphrase"))
                .build();

        try {
            service.write(dto);
            resp.sendRedirect(req.getContextPath() + "/posts");

        } catch (IllegalArgumentException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.setAttribute("post", dto); // 이전에 입력한 값을 폼에 다시 채우기
            req.setAttribute("mode", "new");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/form.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
