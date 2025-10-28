package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);

        req.setAttribute("dto",dto);
        req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}