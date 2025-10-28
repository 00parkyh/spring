package com.ssg.homework_board.controller;

import com.ssg.homework_board.dto.PostDTO;
import com.ssg.homework_board.service.PostService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostListServlet", urlPatterns = "/posts")
@Log4j2
public class PostListServlet extends HttpServlet {
    private PostService service = PostService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/posts doGet() 호출");
        log.info("/posts list............ ");

        try{
            List<PostDTO> dtoList = service.getList();
            req.setAttribute("dtoList", dtoList);

            req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e);
            throw new ServletException("posts list error");
        }
    }

}
