package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRemoveController",urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Long tno = Long.parseLong(req.getParameter("tno"));

        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setTno(tno);
        super.doPost(req, resp);
    }
}