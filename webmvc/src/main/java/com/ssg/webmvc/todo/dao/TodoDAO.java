package com.ssg.webmvc.todo.dao;

import com.ssg.webmvc.todo.domain.TodoVo;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    public String getTime() {
        String now = null;

        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select now()");
            ResultSet rs = pstmt.executeQuery();
        ){
            rs.next();
            now = rs.getString(1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    //@Cleanup 은 사용한 자원을 자동으로 해제해주는 역할을 한다.
    //아래의 코드와 위 코드의 차이점은 @Cleanup 으로 try-catch 문을 생략했다는 것이다.

    public String getTime2() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }

    public void insert(TodoVo vo) throws Exception {
        String sql = "insert into todo(title,dueDate,finished) values(?,?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,vo.getTitle());
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3,vo.isFinished());
        pstmt.executeUpdate();
    }

    public List<TodoVo> selectAll() throws Exception{
        String sql = "select * from todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoVo> list = new ArrayList<>();
        while (rs.next()) {
            TodoVo vo = TodoVo.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();
            list.add(vo);
        }
        return list;
    }

    public TodoVo selectOne(Long tno) throws Exception {
        String sql = "select * from todo where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();
        TodoVo vo = TodoVo.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .build();
        return vo;
    }

    public void deleteOne(Long tno) throws Exception {
        String sql="delete from todo where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, tno);
        pstmt.executeUpdate();
    }

    public void updateOne(TodoVo todoVo) throws Exception{
        String sql = "update todo set title=?,dueDate=?,finished=? where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,todoVo.getTitle());
        pstmt.setDate(2,Date.valueOf(todoVo.getDueDate()));
        pstmt.setBoolean(3,todoVo.isFinished());
        pstmt.setLong(4,todoVo.getTno());

        pstmt.executeUpdate();
    }

}
