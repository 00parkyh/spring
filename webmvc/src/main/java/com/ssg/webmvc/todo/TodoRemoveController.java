package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRemoveController",urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Long tno = Long.parseLong(req.getParameter("tno"));

        try {
            todoService.deleteOne(tno);
        } catch (Exception e) {
            throw new ServletException("read error");
        }
        resp.sendRedirect("/todo/list");

    }
}